package example.operator

import flow.builder.flowOf
import flow.operator.distinctUntilChangedBy

data class User(val id: Int, val name: String)

suspend fun main() {
    flowOf(
        User(1, "짱구"),
        User(1, "철수"),
        User(2, "철수"),
        User(2, "유리"),
        User(1, "유리"),
    ).distinctUntilChangedBy { it.id }.collect { println(it) }
}
