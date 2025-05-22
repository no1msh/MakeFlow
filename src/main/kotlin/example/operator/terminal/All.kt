package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.all

suspend fun main() {
    val resultTrue = flowOf(1, 2, 3, 4, 5)
        .all { it > 0 }

    val resultFalse = flowOf(1, 2, 0, 4, 5)
        .all { it > 0 }

    println(resultTrue)
    println(resultFalse)
}
