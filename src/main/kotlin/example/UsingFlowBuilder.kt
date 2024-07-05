package example

import flow.Flow
import flow.flow

suspend fun main() {
    val flow: Flow<String> = flow {
        emit("반")
        emit("달")
        emit("벨로그")
    }

    flow.collect { print(it) }
    println()
    flow.collect { print(it) }
}

// 반달벨로그
// 반달벨로그
