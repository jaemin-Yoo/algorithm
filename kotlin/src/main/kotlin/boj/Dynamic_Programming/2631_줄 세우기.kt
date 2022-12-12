package boj.Greedy

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1)
    var result = 0
    repeat(n) {
        val a = readLine().toInt()
        dp[a] = dp.copyOfRange(0, a).maxOf { it } + 1
        result = max(result, dp[a])
    }
    println(n - result)
    close()
}