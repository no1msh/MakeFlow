package example

import flow.Flow
import flow.FlowCollector

suspend fun main() {
    val builder: suspend FlowCollector.() -> Unit = {
        emit(1)
        emit(2)
        emit(3)
    }

    val flow: Flow = object : Flow {
        override suspend fun collect(flowCollector: FlowCollector) {
            flowCollector.builder()
        }
    }

    flow.collect { print(it) }
    println()
    flow.collect { print(it) }
}

// 123
// 123
