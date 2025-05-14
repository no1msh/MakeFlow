package flow.lifecycle

import flow.Flow
import flow.flow

fun <T> Flow<T>.onStart(
    action: suspend () -> Unit
): Flow<T> = flow {
    action()
    collect { value ->
        emit(value)
    }
}
