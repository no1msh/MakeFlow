package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.last

suspend fun main() {
    val lastElement = flowOf(1, 2, 3).last()
    println(lastElement)
}
