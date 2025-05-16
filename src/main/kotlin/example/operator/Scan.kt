package example.operator

import flow.builder.flowOf
import flow.lifecycle.onEach
import flow.operator.scan
import kotlinx.coroutines.delay

suspend fun main() {
    flowOf(1, 2, 3, 4)
        .onEach { delay(1000) }
        .scan(0) { accumulator, value -> accumulator + value }
        .collect { println(it) }
}
