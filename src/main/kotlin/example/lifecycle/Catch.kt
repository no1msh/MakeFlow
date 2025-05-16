package example.lifecycle

import flow.builder.flowOf
import flow.lifecycle.catch
import flow.lifecycle.onEach

suspend fun main() {
    flowOf("Message")
        .catch { println("catch: $it") }
        .onEach { throw IllegalArgumentException() }
        .collect { println("collect: $it") }
}
