package boj.String

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln() }
    run breaker@ {
        arr.forEach {
            if (it.reversed() in arr) {
                println("${it.length} ${it[it.length / 2]}")
                return@breaker
            }
        }
    }
}