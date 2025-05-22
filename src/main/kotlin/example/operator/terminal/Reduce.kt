package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.reduce

suspend fun main() {
    val result = flowOf(1, 2, 3)
        .reduce { accumulator, value ->
            accumulator + value
        }
    println(result)
}
