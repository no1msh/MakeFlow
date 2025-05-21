package flow.operator.terminal

import flow.builder.Flow
import flow.builder.FlowCollector


suspend fun <T> Flow<T>.collectIndexed(action: suspend (index: Int, value: T) -> Unit) {
    collect(object : FlowCollector<T> {
        var index = 0
        override suspend fun emit(value: T) {
            require(index >= 0) { "Overflow가 발생하였습니다." }
            action(index++, value)
        }
    })
}
