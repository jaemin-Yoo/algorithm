package boj.dynamic_programming

/**
 * 문제 번호: (2748)
 * 문제 이름: (피보나치 수 2)
 * 소요 시간(분): (5)
 */

private const val MAX_SIZE = 90

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = LongArray(MAX_SIZE + 1)
    dp[1] = 1
    for (i in 2 until MAX_SIZE + 1) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[n])
}