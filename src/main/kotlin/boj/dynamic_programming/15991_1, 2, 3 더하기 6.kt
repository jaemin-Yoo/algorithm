package boj.dynamic_programming

/**
 * 문제 번호: (15991)
 * 문제 이름: (1, 2, 3 더하기 6)
 * 소요 시간(분): (x)
 */

private const val MAX_SIZE = 100_000
private const val MOD = 1_000_000_009

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = LongArray(MAX_SIZE + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 2
    dp[4] = 3
    dp[5] = 3
    dp[6] = 6
    for (i in 7 until MAX_SIZE + 1) {
        dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(dp[n])
    }
}