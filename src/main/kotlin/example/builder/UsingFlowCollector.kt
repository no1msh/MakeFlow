package example.builder

import flow.builder.FlowCollector

suspend fun main() {
    val lambdaHasFlowCollector: suspend (FlowCollector<Int>) -> Unit = {
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
