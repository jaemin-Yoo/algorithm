package boj.Implementation

fun main() {
    val chess = listOf(1, 1, 2, 2, 2, 8)
    val arr = readln().split(' ').map { it.toInt() }
    for (i in 0 until 6) {
        val diff = chess[i] - arr[i]
        print("$diff ")
    }
}