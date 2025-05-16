package example.lifecycle

import flow.builder.flowOf
import flow.lifecycle.onEach


suspend fun main() {
    flowOf(1, 2, 3)
        .onEach { println("onEach: $it") }
        .collect { println("collect: $it") }
}
