package example.lifecycle

import flow.builder.flowOf
import flow.lifecycle.launchIn
import flow.lifecycle.onEach
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

private val newScope = CoroutineScope(CoroutineName("새로운 스코프"))

suspend fun main(): Unit = coroutineScope {
    flowOf(1, 2, 3)
        .onEach {
            val ctx: CoroutineContext = currentCoroutineContext()
            val name = ctx[CoroutineName]?.name
            println("name=$name")
        }
        .launchIn(newScope)

    delay(1000)
}
