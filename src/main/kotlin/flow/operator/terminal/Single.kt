@file:Suppress("UNCHECKED_CAST")

package flow.operator.terminal

import flow.builder.Flow
import flow.internal.NullSurrogate

suspend fun <T> Flow<T>.single(): T {
    var result: Any? = NullSurrogate

    collect { value ->
        require(result === NullSurrogate) { "Flow가 한 개보다 많은 원소를 가지고 있습니다." }
        result = value
    }

    if (result === NullSurrogate) throw NoSuchElementException("Flow가 비어 있습니다.")
    return result as T
}
