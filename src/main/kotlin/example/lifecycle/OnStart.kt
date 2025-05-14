package example.lifecycle

import flow.flowOf
import flow.lifecycle.onEach
import flow.lifecycle.onStart
import kotlinx.coroutines.delay

suspend fun main() {
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart { println("Start") }
        .collect { println(it) }
}
