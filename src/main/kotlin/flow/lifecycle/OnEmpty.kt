package flow.lifecycle

import flow.builder.Flow
import flow.builder.FlowCollector
import flow.builder.flow

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
