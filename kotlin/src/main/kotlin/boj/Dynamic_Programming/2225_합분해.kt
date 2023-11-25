package boj.Dynamic_Programming.합분해2225

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dp = Array(k) { LongArray(n) }
    for (i in 0 until k) {
        dp[i][0] = i + 1L
    }
    for (j in 0 until n) {
        dp[0][j] = 1L
    }

    for (i in 1 until k) {
        for (j in 1 until n) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000
        }
    }
    println(dp[k - 1][n - 1])
    close()
}