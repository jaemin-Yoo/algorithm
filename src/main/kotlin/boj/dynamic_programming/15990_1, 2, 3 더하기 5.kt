package boj.dynamic_programming

/**
 * 문제 번호: (15990)
 * 문제 이름: (1, 2, 3 더하기 5)
 * 소요 시간(분): (x)
 */

private const val MAX_SIZE = 100001
private const val MOD = 1000000009

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = Array(MAX_SIZE) { LongArray(3) }
    dp[1] = longArrayOf(1, 0 ,0)
    dp[2] = longArrayOf(0, 1 ,0)
    dp[3] = longArrayOf(1, 1 ,1)
    for (i in 4 until MAX_SIZE) {
        dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD
        dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % MOD
        dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % MOD
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(dp[n].sum() % MOD)
    }
}