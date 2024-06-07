package boj.dynamic_programming

/**
 * 문제 번호: (9251)
 * 문제 이름: (LCS)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val a = br.readLine()
    val b = br.readLine()
    val n = a.length
    val m = b.length
    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            dp[i][j] = if (a[i - 1] == b[j - 1]) {
                dp[i - 1][j - 1] + 1
            } else {
                max(dp[i][j - 1], dp[i - 1][j])
            }
        }
    }
    println(dp[n][m])
}