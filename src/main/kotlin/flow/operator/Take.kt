package flow.operator

import flow.Flow
import flow.flow
import kotlin.coroutines.cancellation.CancellationException

fun <T> Flow<T>.take(count: Int): Flow<T> = flow {
    var consumed = 0
    try {
        collect { value ->
            if (++consumed < count) {
                emit(value)
            } else {
                emit(value)
                throw CancellationException()
            }
        }
    } catch (e: CancellationException) {
        // 이 함수에서 발생시킨 예외인지 확인
        // 만약 아니라면 다시 예외를 발생시킵니다.
    }
}
