package example.operator

import flow.builder.flowOf
import flow.operator.distinctUntilChanged


suspend fun main() {
    flowOf(1, 2, 2, 3, 2, 1, 1, 3)
        .distinctUntilChanged()
        .collect { print(it) }
}
