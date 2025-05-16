package flow.lifecycle

import flow.builder.Flow
import flow.builder.FlowCollector
import flow.builder.flow

fun <T> Flow<T>.onCompletion(
    action: suspend FlowCollector<T>.(cause: Throwable?) -> Unit
): Flow<T> = flow {
    var cause: Throwable? = null
    try {
        this@onCompletion.collect(this@flow)
    } catch (e: Throwable) {
        cause = e
        throw e
    } finally {
        this@flow.action(cause)
    }
}
