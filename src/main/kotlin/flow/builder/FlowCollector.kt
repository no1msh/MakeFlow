package flow.builder

fun interface FlowCollector<T> {
    suspend fun emit(value: T)
}
