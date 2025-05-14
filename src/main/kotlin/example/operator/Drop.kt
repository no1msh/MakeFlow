package example.operator

import flow.asFlow
import flow.operator.drop


suspend fun main() {
    ('A'..'Z').asFlow()
        .drop(20)
        .collect { print(it) }
}
