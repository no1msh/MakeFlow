fun interface FlowCollector {
    suspend fun emit(value: Int)
}
