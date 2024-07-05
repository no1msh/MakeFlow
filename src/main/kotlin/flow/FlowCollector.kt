package flow

fun interface FlowCollector {
    suspend fun emit(value: Int)
}
