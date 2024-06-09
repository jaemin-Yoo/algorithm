package boj.dynamic_programming

/**
 * 문제 번호: (11660)
 * 문제 이름: (구간 합 구하기 5)
 * 소요 시간(분): (13)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        val row = br.readLine().split(' ').map { it.toInt() }
        graph.add(row)
    }
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in 1 until n + 1) {
        for (j in 1 until n + 1) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + graph[i - 1][j - 1]
        }
    }
    repeat(m) {
        val (x1, y1, x2, y2) = br.readLine().split(' ').map { it.toInt() }
        println(dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1]) + dp[x1 - 1][y1 - 1])
    }
}