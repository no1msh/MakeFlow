package example.operator

import flow.flowOf
import flow.operator.map
import kotlinx.coroutines.delay


suspend fun main() {
    flowOf("A", "B", "C")
        .map {
            delay(1000)
            it.lowercase()
        }
        .collect { println(it) }
}
