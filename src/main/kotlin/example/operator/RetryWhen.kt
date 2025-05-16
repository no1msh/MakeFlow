package example.operator

import flow.flow
import flow.operator.retryWhen
import kotlinx.coroutines.delay

suspend fun main() {
    flow {
        emit(1)
        emit(2)
        error("e")
    }.retryWhen { cause, attempt ->
        delay(1000 * attempt)
        attempt != 2L
    }.collect(::println)
}
