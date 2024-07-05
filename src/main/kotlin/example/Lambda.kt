package example

fun main() {
    val lambda: () -> Unit = {
        print(1)
        print(2)
        print(3)
    }

    lambda
    lambda()
    lambda()
}

// 123123
