package flow.operator.terminal

import flow.builder.Flow

suspend fun <T, C : MutableCollection<T>> Flow<T>.toCollection(destination: C): C {
    collect { value ->
        destination.add(value)
    }
    return destination
}

suspend fun <T> Flow<T>.toList(destination: MutableList<T> = ArrayList()): List<T> {
    return toCollection(destination)
}

suspend fun <T> Flow<T>.toSet(destination: MutableSet<T> = LinkedHashSet()): Set<T> {
    return toCollection(destination)
}
