package example

import flow.FlowCollector

suspend fun main() {
    val lambdaHasFlowCollector: suspend FlowCollector.() -> Unit = {
        emit(1)
        emit(2)
        emit(3)
    }

    lambdaHasFlowCollector { print(it) }
    println()
    lambdaHasFlowCollector { print(it) }
}

// 123
// 123
