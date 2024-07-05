package example

import flow.Flow
import flow.FlowCollector

suspend fun main() {
    val builder: suspend FlowCollector<Int>.() -> Unit = {
        emit(1)
        emit(2)
        emit(3)
    }

    val flow: Flow<Int> = object : Flow<Int> {
        override suspend fun collect(flowCollector: FlowCollector<Int>) {
            flowCollector.builder()
        }
    }

    flow.collect { print(it) }
    println()
    flow.collect { print(it) }
}

// 123
// 123
