package example

suspend fun main() {
    val lambdaHasLambda: suspend ((Int) -> Unit) -> Unit = { emit ->
        emit(1)
        emit(2)
        emit(3)
    }

    lambdaHasLambda { number: Int ->
        print(number)
    }

    println()

    lambdaHasLambda { number: Int ->
        print(number)
    }
}

// 123
// 123
