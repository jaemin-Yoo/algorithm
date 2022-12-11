package boj.Greedy

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n + 1)

    var mx = 0
    list.forEach { i ->
        dp[i] = dp[i - 1] + 1
        mx = max(mx, dp[i])
    }
    println(n - mx)
    close()
}