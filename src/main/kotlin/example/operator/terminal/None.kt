package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.any
import flow.operator.terminal.none

suspend fun main() {
    val resultAnyTrue = flowOf(1, 2, 3, 4, 5).any { it > 0 }
    val resultNoneFalse = flowOf(1, 2, 3, 4, 5).none { it > 0 }

    val resultAnyFalse = flowOf(1, 2, 3, 4, 5).any { it == 0 }
    val resultNoneTrue = flowOf(1, 2, 3, 4, 5).none { it == 0 }

    println(resultAnyTrue)
    println(resultNoneFalse)
    println(resultAnyFalse)
    println(resultNoneTrue)
}
