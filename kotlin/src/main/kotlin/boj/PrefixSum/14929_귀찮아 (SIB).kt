package boj.PrefixSum

fun main() {
    val n = readln().toInt()
    val seq = readln().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { 0 }

    for (i in 1 until n + 1) {
        arr[i] = seq[i - 1] + arr[i - 1]
    }

    var result = 0L
    for (i in 0 until n) {
        result += seq[i] * (arr[n] - arr[i + 1])
    }
    println(result)
}