@file:Suppress("UNCHECKED_CAST")

package flow.operator.terminal

import flow.builder.Flow
import flow.internal.NullSurrogate

suspend fun <T> Flow<T>.last(): T {
    var result: Any? = NullSurrogate

    collect { value ->
        result = value
    }

    if (result === NullSurrogate) throw NoSuchElementException("적어도 하나의 원소는 수집되어야 합니다.")
    return result as T
}
