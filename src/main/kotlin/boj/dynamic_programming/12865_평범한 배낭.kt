package boj.dynamic_programming

/**
 * 문제 번호: (12865)
 * 문제 이름: (평범한 배낭)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val ws = mutableListOf(0)
    val vs = mutableListOf(0)
    repeat(n) {
        val (w, v) = br.readLine().split(' ').map { it.toInt() }
        ws.add(w)
        vs.add(v)
    }

    val dp = Array(n + 1) { IntArray(k + 1) }
    for (i in 1 until n + 1) {
        for (j in 1 until k + 1) {
            if (j < ws[i]) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - ws[i]] + vs[i])
            }
        }
    }
    println(dp[n][k])
}