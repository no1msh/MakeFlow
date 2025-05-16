package flow.operator

import flow.builder.Flow
import flow.builder.FlowCollector
import flow.builder.flow

fun <T> Flow<T>.retryWhen(
    predicate: suspend FlowCollector<T>.(
        cause: Throwable,
        attempt: Long,
    ) -> Boolean,
): Flow<T> = flow {
    var attempt = 0L
    do {
        val shallRetry: Boolean = try {
            collect { emit(it) }
            false
        } catch (e: Throwable) {
            predicate(e, attempt++).also { if (!it) throw e }
        }
    } while (shallRetry)
}
