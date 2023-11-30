package boj.String.공통부분문자열5582

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val s1 = readLine()
    val s2 = readLine()
    val dp = Array(s1.length) { IntArray(s2.length) }
    var result = 0
    for (i in s1.indices) {
        for (j in s2.indices) {
            if (s1[i] == s2[j]) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                }
                result = max(result, dp[i][j])
            }
        }
    }
    println(result)
    close()
}