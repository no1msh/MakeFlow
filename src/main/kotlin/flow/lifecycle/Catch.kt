package flow.lifecycle

import flow.Flow
import flow.FlowCollector
import flow.flow
import kotlin.coroutines.cancellation.CancellationException

fun <T> Flow<T>.catch(
    action: suspend FlowCollector<T>.(cause: Throwable) -> Unit
): Flow<T> = flow {
    var downstreamError: Throwable? = null

    try {
        // 1. upstream.collect(...) 만 감쌉니다.
        this@catch.collect { value ->
            try {
                emit(value)
            } catch (e: Throwable) {
                // emit 중 발생한 예외는 기록해두고 다시 던집니다.
                downstreamError = e
                throw e
            }
        }
    } catch (e: Throwable) {
        // 2. downstream error 혹은 취소 예외면 그대로 다시 던집니다.
        if (e === downstreamError || e is CancellationException) {
            throw e
        }
        // 3. 그 외, 순수 upstream 예외만 잡아서 action 실행합니다.
        action(e)
    }
}
