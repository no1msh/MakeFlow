package example.operator.terminal

import flow.builder.flow
import flow.operator.terminal.count

suspend fun main() {
    val count = flow {
        repeat(10) {
            emit(it)
        }
    }.count()

    val countWithPredicate = flow {
        repeat(10) {
            emit(it)
        }
    }.count { it % 2 == 0 }

    println(count)
    println(countWithPredicate)
}
