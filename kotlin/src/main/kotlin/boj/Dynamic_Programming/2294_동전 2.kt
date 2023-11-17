package boj.Dynamic_Programming.동전22294

import kotlin.math.min

private const val MAX_SIZE = 10001

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1) { MAX_SIZE }
    dp[0] = 0
    repeat(n) {
        val c = readLine().toInt()
        for (i in c until k + 1) {
            dp[i] = min(dp[i], dp[i - c] + 1)
        }
    }
    val result = if (dp[k] == MAX_SIZE) {
        -1
    } else {
        dp[k]
    }
    println(result)
    close()
}