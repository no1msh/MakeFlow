package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.firstOrNull

suspend fun main() {
    val firstElement: Int? = flowOf(1, 2, 3).firstOrNull()
    val firstElementByPredicate: Int? = flowOf(1, 2, 3).firstOrNull { it == 0 }

    println(firstElement)
    println(firstElementByPredicate)
}
