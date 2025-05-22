package flow.operator.terminal

import flow.builder.Flow
import kotlin.coroutines.cancellation.CancellationException


suspend fun <T> Flow<T>.any(predicate: suspend (T) -> Boolean): Boolean {
    var found = false

    val cancellationExceptionFromThis = CancellationException()

    try {
        collect { value ->
            val satisfies = predicate(value)
            if (satisfies) {
                found = true
                throw cancellationExceptionFromThis
            }
        }
    } catch (e: CancellationException) {
        if (e !== cancellationExceptionFromThis) {
            throw e
        }
    }
    return found
}
