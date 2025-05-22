package flow.operator.terminal

import flow.builder.Flow


suspend fun <T> Flow<T>.none(predicate: suspend (T) -> Boolean): Boolean = !any(predicate)
