package flow.operator.terminal

import flow.builder.Flow
import kotlin.coroutines.cancellation.CancellationException


suspend fun <T> Flow<T>.all(predicate: suspend (T) -> Boolean): Boolean {
    var foundCounterExample = false
    val cancellationExceptionFromThis = CancellationException()

    try {
        collect { value ->
            val satisfies = predicate(value)
            if (!satisfies) {
                foundCounterExample = true
                throw cancellationExceptionFromThis
            }
        }
    } catch (e: CancellationException) {
        if (e !== cancellationExceptionFromThis) {
            throw e
        }
    }
    return !foundCounterExample
}
