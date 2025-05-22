@file:Suppress("UNCHECKED_CAST")

package flow.operator.terminal

import flow.builder.Flow
import flow.internal.NullSurrogate

suspend fun <S, T : S> Flow<T>.reduce(operation: suspend (accumulator: S, value: T) -> S): S {
    var accumulator: Any? = NullSurrogate

    collect { value ->
        accumulator = if (accumulator !== NullSurrogate) {
            operation(accumulator as S, value)
        } else value
    }

    if (accumulator === NullSurrogate) throw NoSuchElementException("빈 Flow는 reduce를 사용할 수 없습니다.")
    return accumulator as S
}
