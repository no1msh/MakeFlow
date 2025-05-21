package example.operator.terminal

import flow.builder.flowOf
import flow.operator.filter
import flow.operator.terminal.toCollection
import flow.operator.terminal.toList
import flow.operator.terminal.toSet

suspend fun main() {
    val queue = ArrayDeque<String>()
    flowOf("A", "B", "C")
        .toCollection(queue)
    println(queue)

    val evenNumbers: List<Int> = flowOf(1, 2, 3, 4, 5, 6, 7, 8)
        .filter { it % 2 == 0 }
        .toList()
    println(evenNumbers)

    val words = flowOf("apple", "banana", "apple", "cherry", "banana")
    val uniqueWords: Set<String> = words
        .toSet()
    println(uniqueWords)
}
