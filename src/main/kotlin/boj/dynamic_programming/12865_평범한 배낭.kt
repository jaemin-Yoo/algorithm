package boj.dynamic_programming

/**
 * 문제 번호: (12865)
 * 문제 이름: (평범한 배낭)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val dp = Array(n + 1) { IntArray(k + 1) }
    val w = mutableListOf(0)
    val v = mutableListOf(0)
    repeat(n) { i ->
        val (weight, value) = br.readLine().split(' ').map { it.toInt() }
        w.add(weight)
        v.add(value)
    }

    for (i in 1 until n + 1) {
        for (j in 1 until k + 1) {
            if (j < w[i]) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j - w[i]] + v[i], dp[i - 1][j])
            }
        }
    }
    println(dp[n][k])
}