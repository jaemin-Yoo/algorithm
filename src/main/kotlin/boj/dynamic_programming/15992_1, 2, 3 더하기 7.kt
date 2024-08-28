package boj.dynamic_programming

/**
 * 문제 번호: (15992)
 * 문제 이름: (1, 2, 3 더하기 7)
 * 소요 시간(분): (25)
 */

private const val MAX_SIZE = 1000
private const val MOD = 1_000_000_009

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = Array(MAX_SIZE + 1) { LongArray(MAX_SIZE + 1) }
    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 2
    dp[3][3] = 1
    for (i in 4 until MAX_SIZE + 1) {
        for (j in i downTo 2) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % MOD
        }
    }
    repeat(t) {
        val (n, m) = br.readLine().split(' ').map { it.toInt() }
        println(dp[n][m])
    }
}