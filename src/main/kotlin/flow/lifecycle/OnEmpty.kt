package flow.lifecycle

import flow.Flow
import flow.FlowCollector
import flow.flow

fun <T> Flow<T>.onEmpty(
    action: suspend FlowCollector<T>.() -> Unit
): Flow<T> = flow {
    var isEmpty = true
    collect {
        isEmpty = false
        emit(it)
    }
    if (isEmpty) {
        this@flow.action()
    }
}
