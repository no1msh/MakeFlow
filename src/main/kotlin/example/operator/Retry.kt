package example.operator

import flow.builder.flow
import flow.operator.retry


suspend fun main() {
    flow {
        emit(1)
        emit(2)
        error("E")
        emit(3)
    }.retry(3) {
        print(it.message)
        true
    }.collect { print(it) }
}
