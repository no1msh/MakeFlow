package flow

fun <T> flow(
    builder: suspend FlowCollector<T>.() -> Unit
): Flow<T> = object : Flow<T> {
    override suspend fun collect(flowCollector: FlowCollector<T>) {
        flowCollector.builder()
    }
}
