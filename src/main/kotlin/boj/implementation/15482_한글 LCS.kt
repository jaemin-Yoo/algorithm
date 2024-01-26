package boj.implementation

/**
 * 문제 번호: (15482)
 * 문제 이름: (한글 LCS)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine()
    val b = readLine()
    val n = a.length
    val m = b.length
    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in a.indices) {
        for (j in b.indices) {
            if (a[i] == b[j]) {
                dp[i + 1][j + 1] = dp[i][j] + 1
            } else {
                dp[i + 1][j + 1] = max(dp[i + 1][j], dp[i][j + 1])
            }
        }
    }
    println(dp[n][m])
    close()
}