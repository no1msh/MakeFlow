package flow.lifecycle

import flow.Flow
import flow.FlowCollector
import flow.flow

fun <T> Flow<T>.onStart(
    action: suspend FlowCollector<T>.() -> Unit
): Flow<T> = flow {
    this@flow.action()
    this@onStart.collect(this@flow)
}
