package flow.operator

import flow.builder.Flow
import flow.builder.flow

fun <T> Flow<T>.drop(count: Int): Flow<T> = flow {
    var skipped = 0
    collect { value ->
        if (skipped >= count) emit(value) else ++skipped
    }
}
