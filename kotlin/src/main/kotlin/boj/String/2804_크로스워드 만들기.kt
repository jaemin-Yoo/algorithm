package boj.String

fun main() {
    val (a, b) = readln().split(' ')
    breaker@ for (i in a.indices) {
        for (j in b.indices) {
            if (a[i] == b[j]) {
                printResult(i, j, a, b)
                break@breaker
            }
        }
    }
}

fun printResult(i: Int, j: Int, a: String, b: String) {
    for (idx in b.indices) {
        if (idx == j) {
            println(a)
        } else {
            println(".".repeat(i) + b[idx] + ".".repeat(a.lastIndex - i))
        }
    }
}