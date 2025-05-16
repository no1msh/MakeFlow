package flow.lifecycle

import flow.builder.Flow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun <T> Flow<T>.launchIn(scope: CoroutineScope): Job = scope.launch {
    collect {}
}
