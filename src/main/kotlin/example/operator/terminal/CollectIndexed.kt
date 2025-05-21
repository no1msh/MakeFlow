package example.operator.terminal

import flow.builder.flowOf
import flow.operator.terminal.collectIndexed

suspend fun main() {
    flowOf("A", "B", "C")
        .collectIndexed { index, value ->
            println("${index + 1}번째 원소 $value")
        }
}
