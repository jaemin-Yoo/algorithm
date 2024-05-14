package boj.dynamic_programming

/**
 * 문제 번호: (1463)
 * 문제 이름: (1로 만들기)
 * 소요 시간(분): (x)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    for (i in 2 until n + 1) {
        dp[i] = if (i % 6 == 0) {
            listOf(dp[i - 1], dp[i / 2], dp[i / 3]).minOf { it } + 1
        } else if (i % 2 == 0) {
            min(dp[i - 1], dp[i / 2]) + 1
        } else if (i % 3 == 0) {
            min(dp[i - 1], dp[i / 3]) + 1
        } else {
            dp[i - 1] + 1
        }
    }
    print(dp[n])
}