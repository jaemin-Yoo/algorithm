package boj.dynamic_programming

/**
 * 문제 번호: (17484)
 * 문제 이름: (진우의 달 여행 (Small))
 * 소요 시간(분): (23)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    repeat(n) { i ->
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[i] = row
    }

    val dp = Array(n) { Array(m) { IntArray(3) { Int.MAX_VALUE } } }
    for (j in 0 until m) {
        for (k in 0 until 3) {
            dp[0][j][k] = graph[0][j]
        }
    }

    for (i in 1 until n) {
        for (j in 0 until m) {
            if (j - 1 >= 0) {
                dp[i][j][0] = min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + graph[i][j]
            }
            dp[i][j][1] = min(dp[i - 1][j][0], dp[i - 1][j][2]) + graph[i][j]
            if (j + 1 < m) {
                dp[i][j][2] = min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + graph[i][j]
            }
        }
    }

    var result = Int.MAX_VALUE
    for (j in 0 until m) {
        for (k in 0 until 3) {
            result = min(result, dp[n - 1][j][k])
        }
    }
    println(result)
}