package example

import kotlinx.coroutines.delay

suspend fun main() {
    val suspendLambda: suspend () -> Unit = {
        print(1)
        delay(1000)
        print(2)
        delay(1000)
        print(3)
    }

    suspendLambda()
    println()
    suspendLambda()
}

// 1(1초 후)2(1초 후)3
// 1(1초 후)2(1초 후)3
