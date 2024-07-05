package flow

interface Flow<T> {
    suspend fun collect(flowCollector: FlowCollector<T>)
}
