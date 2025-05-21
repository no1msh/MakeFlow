@file:Suppress("UNCHECKED_CAST")

package flow.operator.terminal

import flow.builder.Flow
import kotlin.coroutines.cancellation.CancellationException


suspend fun <T> Flow<T>.first(): T {
    var result: Any? = null
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

    if (result == null) throw NoSuchElementException("적어도 하나의 원소는 수집되어야 합니다.")
    return result as T
}

suspend fun <T> Flow<T>.first(predicate: suspend (T) -> Boolean): T {
    var result: Any? = null
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

    if (result == null) throw NoSuchElementException("적어도 하나의 원소는 수집되어야 합니다.")
    return result as T
}
