package example

import flow.Flow
import flow.flow

suspend fun main() {
    val flow: Flow = flow {
        emit(1)
        emit(2)
        emit(3)
    }

    flow.collect { print(it) }
    println()
    flow.collect { print(it) }
}

// 123
// 123
