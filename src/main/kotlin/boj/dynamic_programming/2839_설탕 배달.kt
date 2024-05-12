package boj.dynamic_programming

/**
 * 문제 번호: (2839)
 * 문제 이름: (설탕 배달)
 * 소요 시간(분): (x)
 */

import kotlin.math.min
import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(5001) { -1 }
    dp[3] = 1
    dp[5] = 1
    for (i in 6 until n + 1) {
        dp[i] = if (dp[i - 3] != -1 && dp[i - 5] != -1) {
            min(dp[i - 3], dp[i - 5]) + 1
        } else {
            val mx = max(dp[i - 3], dp[i - 5])
            if (mx == -1) {
                -1
            } else {
                mx + 1
            }
        }
    }
    println(dp[n])
}