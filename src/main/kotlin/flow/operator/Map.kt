package flow.operator

import flow.Flow
import flow.flow

fun <T, R> Flow<T>.map(
    transformation: suspend (T) -> R
): Flow<R> = flow {
    collect { value ->
        emit(transformation(value))
    }
}
