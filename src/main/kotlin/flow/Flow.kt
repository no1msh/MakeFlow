package flow

interface Flow {
    suspend fun collect(flowCollector: FlowCollector)
}
