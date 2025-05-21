package flow.operator.terminal

import flow.builder.Flow

suspend fun <T> Flow<T>.collect() {
    collect {}
}
