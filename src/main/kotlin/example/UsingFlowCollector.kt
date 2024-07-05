package example

import flow.FlowCollector

suspend fun main() {
    val lambdaHasFlowCollector: suspend (FlowCollector) -> Unit = {
        it.emit(1)
        it.emit(2)
        it.emit(3)
    }

    lambdaHasFlowCollector { print(it) }
    println()
    lambdaHasFlowCollector { print(it) }
}

// 123
// 123
