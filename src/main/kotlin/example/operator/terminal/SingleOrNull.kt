package example.operator.terminal

import flow.builder.Flow
import flow.builder.flowOf
import flow.operator.terminal.singleOrNull

suspend fun main() {
    val flow0: Flow<Int> = flowOf()
    val flow1: Flow<Int> = flowOf(1)
    val flow2: Flow<Int> = flowOf(1, 2)

    println(flow0.singleOrNull())
    println(flow1.singleOrNull())
    println(flow2.singleOrNull())
}
