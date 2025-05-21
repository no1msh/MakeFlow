package flow.operator.terminal

import flow.builder.Flow
import kotlin.coroutines.cancellation.CancellationException

suspend fun <T> Flow<T>.firstOrNull(): T? {
    var result: T? = null
    val cancellationExceptionFromThis = CancellationException()

    try {
        collect { value ->
            result = value
            throw cancellationExceptionFromThis
        }
    } catch (e: CancellationException) {
        if (e !== cancellationExceptionFromThis) {
            throw e
        }
    }

    return result
}

suspend fun <T> Flow<T>.firstOrNull(predicate: suspend (T) -> Boolean): T? {
    var result: T? = null
    val cancellationExceptionFromThis = CancellationException()

    try {
        collect { value ->
            if (predicate(value)) {
                result = value
                throw cancellationExceptionFromThis
            }
        }
    } catch (e: CancellationException) {
        if (e !== cancellationExceptionFromThis) {
            throw e
        }
    }

    return result
}
