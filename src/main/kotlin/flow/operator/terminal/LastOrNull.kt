@file:Suppress("UNCHECKED_CAST")

package flow.operator.terminal

import flow.builder.Flow

suspend fun <T> Flow<T>.lastOrNull(): T? {
    var result: T? = null

    collect { value ->
        result = value
    }

    return result as T
}
