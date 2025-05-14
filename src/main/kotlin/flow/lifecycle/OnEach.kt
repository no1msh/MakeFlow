package flow.lifecycle

import flow.Flow
import flow.flow

fun <T> Flow<T>.onEach(
    action: suspend (T) -> Unit
): Flow<T> = flow {
    collect { value ->
        action(value)
        emit(value)
    }
}
