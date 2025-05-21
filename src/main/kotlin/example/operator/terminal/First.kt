package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.first

suspend fun main() {
    val firstElement: Int = flowOf(1, 2, 3).first()
    val firstElementByPredicate: Int = flowOf(1, 2, 3).first { it == 2 }

    println(firstElement)
    println(firstElementByPredicate)
}
