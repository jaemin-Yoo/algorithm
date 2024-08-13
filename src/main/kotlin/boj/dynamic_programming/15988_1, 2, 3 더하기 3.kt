package boj.dynamic_programming

/**
 * 문제 번호: (15988)
 * 문제 이름: (1, 2, 3 더하기 3)
 * 소요 시간(분): (0153)
 */

private const val MAX_SIZE = 1_000_000

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = LongArray(MAX_SIZE + 1)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4 until MAX_SIZE + 1) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_009
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(dp[n])
    }
}