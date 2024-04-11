package boj.dynamic_programming

/**
 * 문제 번호: (1535)
 * 문제 이름: (안녕)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

private const val HEALTH = 99

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val lost = br.readLine().split(' ').map { it.toInt() }
    val joy = br.readLine().split(' ').map { it.toInt() }
    val dp = Array(n + 1) { IntArray(HEALTH + 1) }

    for (i in 1 until n + 1) {
        for (j in 1 until HEALTH + 1) {
            if (j < lost[i - 1]) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j - lost[i - 1]] + joy[i - 1], dp[i - 1][j])
            }
        }
    }
    println(dp[n][HEALTH])
}