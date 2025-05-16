package flow.operator

import flow.Flow
import flow.flow

fun <T, K> Flow<T>.distinctUntilChangedBy(
    keySelector: suspend (T) -> K
): Flow<T> = flow {
    var hasPrevious = false
    var previousKey: K? = null

    collect { value ->
        val key = keySelector(value)
        if (!hasPrevious || previousKey != key) {
            emit(value)
            hasPrevious = true
            previousKey = key
        }
    }
}
