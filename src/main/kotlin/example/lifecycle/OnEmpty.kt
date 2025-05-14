package example.lifecycle

import flow.flow
import flow.lifecycle.onEmpty
import kotlinx.coroutines.delay

suspend fun main() {
    flow<List<Int>> { delay(1000) }
        .onEmpty { emit(emptyList()) }
        .collect { println(it) }
}
