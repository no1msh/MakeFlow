package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.any

suspend fun main() {
    val result = flowOf(1, 2, 3, 4, 5).any { it > 0 }
    println(result)
}
