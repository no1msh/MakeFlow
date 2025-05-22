package example.operator.terminal

import flow.builder.flow
import flow.builder.flowOf
import flow.operator.terminal.lastOrNull

suspend fun main() {
    val stringFlow = flowOf("A", "B", "C")
    val emptyFlow = flow<Int> {}

    println(stringFlow.lastOrNull())
    println(emptyFlow.lastOrNull())
}
