package boj.dynamic_programming

/**
 * 문제 번호: (11052)
 * 문제 이름: (카드 구매하기)
 * 소요 시간(분): (0210 ~ )
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val p = br.readLine().split(' ').map { it.toInt() }
    val dp = IntArray(n)
    for (i in 0 until n) {
        dp[i] = p[i]
        for (j in 0 until i) {
            dp[i] = max(dp[i], dp[j] + dp[i - j - 1])
        }
    }
    println(dp[n - 1])
}