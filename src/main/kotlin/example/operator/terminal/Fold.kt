package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.fold

suspend fun main() {
    val result = flowOf(1, 2)
        .fold(3) { acc, value ->
            acc + value
        }
    println(result)
}
