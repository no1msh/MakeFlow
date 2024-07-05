package flow

fun interface FlowCollector<T> {
    suspend fun emit(value: T)
}
