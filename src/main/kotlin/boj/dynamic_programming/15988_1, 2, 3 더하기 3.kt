package boj.dynamic_programming

/**
 * 문제 번호: (15988)
 * 문제 이름: (1, 2, 3 더하기 3)
 * 소요 시간(분): (x)
 */

private const val MAX_SIZE = 1000001
private const val MOD = 1000000009

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val dp = LongArray(MAX_SIZE)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4 until MAX_SIZE) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD
    }
    repeat(t) {
        val n = readLine().toInt()
        println(dp[n])
    }
    close()
}