package example.operator.terminal

import flow.builder.flowOf
import flow.lifecycle.onEach
import flow.operator.terminal.collect

suspend fun main() {
    flowOf(1, 2, 3)
        .onEach { println(it) }
        .collect()
}
