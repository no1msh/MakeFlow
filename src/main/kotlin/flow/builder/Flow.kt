package flow.builder

interface Flow<T> {
    suspend fun collect(flowCollector: FlowCollector<T>)
}
