package example.operator

import flow.flowOf
import flow.operator.filter


suspend fun main() {
    flowOf(1, 2, 3, 4, 5, 6)
        .filter { it % 2 == 0 }
        .collect { println(it) }
}
