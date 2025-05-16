package flow.operator

import flow.builder.Flow
import flow.builder.flow

fun <T, R> Flow<T>.map(
    transformation: suspend (T) -> R
): Flow<R> = flow {
    collect { value ->
        emit(transformation(value))
    }
}
