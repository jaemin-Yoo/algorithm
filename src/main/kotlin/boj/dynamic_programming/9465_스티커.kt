package boj.dynamic_programming

/**
 * 문제 번호: (9465)
 * 문제 이름: (스티커)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val graph = Array(2) { IntArray(n) }
        graph[0] = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[1] = br.readLine().split(' ').map { it.toInt() }.toIntArray()

        val dp = Array(2) { IntArray(n) }
        dp[0][0] = graph[0][0]
        dp[1][0] = graph[1][0]
        for (j in 1 until n) {
            if (j == 1) {
                dp[0][1] = max(dp[0][1], dp[1][0] + graph[0][1])
                dp[1][1] = max(dp[1][1], dp[0][0] + graph[1][1])
            } else {
                dp[0][j] = max(dp[0][j], max(dp[1][j - 1], dp[1][j - 2]) + graph[0][j])
                dp[1][j] = max(dp[1][j], max(dp[0][j - 1], dp[0][j - 2]) + graph[1][j])
            }
        }
        val result = max(dp[0].maxOf { it }, dp[1].maxOf { it })
        println(result)
    }
}