package flow.lifecycle

import flow.builder.Flow
import flow.builder.FlowCollector
import flow.builder.flow

fun <T> Flow<T>.onStart(
    action: suspend FlowCollector<T>.() -> Unit
): Flow<T> = flow {
    this@flow.action()
    this@onStart.collect(this@flow)
}
