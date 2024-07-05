interface Flow {
    suspend fun collect(collector: FlowCollector)
}
