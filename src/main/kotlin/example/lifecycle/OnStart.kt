package example.lifecycle

import flow.builder.flowOf
import flow.lifecycle.onEach
import flow.lifecycle.onStart
import kotlinx.coroutines.delay

suspend fun main() {
    flowOf(1, 2)
        .onEach { delay(1000) }
        .onStart { emit(0) }
        .collect { println(it) }
}
