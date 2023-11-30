package boj.PrefixSum

import java.lang.Integer.MIN_VALUE
import java.lang.Integer.max

fun main() {
    val (n, k) = readln().trim().split(" ").map { it.toInt() }
    val tempList = readln().trim().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { 0 }
    for (i in 1 until n + 1) {
        dp[i] = dp[i - 1] + tempList[i - 1]
    }

    var result = MIN_VALUE
    for (i in 0 until n - k + 1) {
        result = max(result, dp[i + k] - dp[i])
    }
    println(result)
}