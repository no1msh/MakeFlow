package example.operator.terminal

import flow.builder.Flow
import flow.builder.flowOf
import flow.operator.terminal.single


suspend fun main() {
    val flow0: Flow<Int> = flowOf()
    val flow1: Flow<Int> = flowOf(1)
    val flow2: Flow<Int> = flowOf(1, 2)

    try {
        flow0.single()
    } catch (e: NoSuchElementException) {
        println(e.message)
    }

    println(flow1.single())

    try {
        flow2.single()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
