package boj.dynamic_programming

/**
 * 문제 번호: (15989)
 * 문제 이름: (1, 2, 3 더하기 4)
 * 소요 시간(분): (x)
 */

private const val MAX_SIZE = 10000

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = Array(MAX_SIZE + 1) { IntArray(4) }
    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 1
    dp[3][3] = 1
    for (i in 4 until MAX_SIZE + 1) {
        dp[i][1] = dp[i - 1][1]
        dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
        dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(dp[n].sum())
    }
}