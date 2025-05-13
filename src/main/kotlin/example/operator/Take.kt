package example.operator

import flow.asFlow
import flow.operator.take

suspend fun main() {
    ('A'..'Z').asFlow()
        .take(5)
        .collect { print(it) }
}
