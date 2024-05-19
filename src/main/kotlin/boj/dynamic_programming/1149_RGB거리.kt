package boj.dynamic_programming

/**
 * 문제 번호: (1149)
 * 문제 이름: (RGB거리)
 * 소요 시간(분): (12)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = Array(n) { IntArray(3) }
    repeat(n) { idx ->
        val (r, g, b) = br.readLine().split(' ').map { it.toInt() }
        if (idx == 0) {
            dp[0] = intArrayOf(r, g, b)
            return@repeat
        }

        val mr = r + min(dp[idx - 1][1], dp[idx - 1][2])
        val mg = g + min(dp[idx - 1][0], dp[idx - 1][2])
        val mb = b + min(dp[idx - 1][0], dp[idx - 1][1])
        dp[idx] = intArrayOf(mr, mg, mb)
    }

    println(dp[n - 1].min())
}