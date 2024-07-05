package flow

fun flow(
    builder: suspend FlowCollector.() -> Unit
): Flow = object : Flow {
    override suspend fun collect(flowCollector: FlowCollector) {
        flowCollector.builder()
    }
}
