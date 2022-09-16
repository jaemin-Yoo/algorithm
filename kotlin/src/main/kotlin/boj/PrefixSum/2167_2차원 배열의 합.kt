package boj.PrefixSum

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val graph = Array(n) { Array(m) { 0 } }
    val dp = Array(n + 1) { Array(m + 1) { 0 } }
    for (i in 0 until n) {
        val row = readln().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            graph[i][j] = row[j]
        }
    }

    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            dp[i][j] = graph[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
        }
    }

    val k = readln().toInt()
    repeat(k) {
        val (i, j, x, y) = readln().split(" ").map { it.toInt() }
        val result = dp[x][y] - (dp[x][j - 1] + dp[i - 1][y] - dp[i - 1][j - 1])
        println(result)
    }
}