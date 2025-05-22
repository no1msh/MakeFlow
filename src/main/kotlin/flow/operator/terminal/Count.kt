package flow.operator.terminal

import flow.builder.Flow


suspend fun <T> Flow<T>.count(): Int {
    var i = 0
    collect {
        ++i
    }

    return i
}

suspend fun <T> Flow<T>.count(predicate: suspend (T) -> Boolean): Int {
    var i = 0
    collect { value ->
        if (predicate(value)) {
            ++i
        }
    }

    return i
}
