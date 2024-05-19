package boj.dynamic_programming

/**
 * 문제 번호: (2579)
 * 문제 이름: (계단 오르기)
 * 소요 시간(분): (26)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0 to 0 }
    val scores = mutableListOf<Int>()
    repeat(n) {
        val score = br.readLine().toInt()
        scores.add(score)
    }
    dp[1] = scores[0] to scores[0]

    for (i in 2 until n + 1) {
        dp[i] = max(dp[i - 2].first, dp[i - 2].second) + scores[i - 1] to dp[i - 1].first + scores[i - 1]
    }
    println(max(dp[n].first, dp[n].second))
}