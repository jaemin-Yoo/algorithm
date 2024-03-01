package boj.dynamic_programming

/**
 * 문제 번호: (11048)
 * 문제 이름: (이동하기)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { IntArray(m + 1) }
    graph[0] = IntArray(m + 1) { 0 }
    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in 1 until n + 1) {
        val row = mutableListOf(0)
        val input = readLine().split(" ").map { it.toInt() }
        row.addAll(input)
        graph[i] = row.toIntArray()
    }

    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            val mx = max(dp[i - 1][j], dp[i][j - 1]) + graph[i][j]
            dp[i][j] = mx
        }
    }
    println(dp[n][m])

    close()
}