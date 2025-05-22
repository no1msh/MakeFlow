@file:Suppress("UNCHECKED_CAST")

package flow.operator.terminal

import flow.builder.Flow
import flow.internal.NullSurrogate
import kotlin.coroutines.cancellation.CancellationException

suspend fun <T> Flow<T>.singleOrNull(): T? {
    var result: Any? = NullSurrogate
    val cancellationExceptionFromThis = CancellationException()

    try {
        collect { value ->
            if (result === NullSurrogate) {
                result = value
            } else {
                throw cancellationExceptionFromThis
            }
        }
    } catch (e: CancellationException) {
        if (e !== cancellationExceptionFromThis) {
            throw e
        } else {
            result = NullSurrogate
        }
    }

    return if (result === NullSurrogate)  null else result as T
}
