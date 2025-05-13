package flow

fun <T> flow(
    builder: suspend FlowCollector<T>.() -> Unit
): Flow<T> = object : Flow<T> {
    override suspend fun collect(flowCollector: FlowCollector<T>) {
        flowCollector.builder()
    }
}

public fun <T> Iterator<T>.asFlow(): Flow<T> = flow {
    forEach { value ->
        emit(value)
    }
}

public fun <T> Iterable<T>.asFlow(): Flow<T> = flow {
    forEach { value ->
        emit(value)
    }
}

public fun <T> Sequence<T>.asFlow(): Flow<T> = flow {
    forEach { value ->
        emit(value)
    }
}

public fun <T> flowOf(vararg elements: T): Flow<T> = flow {
    for (element in elements) {
        emit(element)
    }
}
