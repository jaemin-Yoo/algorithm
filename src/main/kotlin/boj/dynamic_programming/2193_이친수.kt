package boj.dynamic_programming

/**
 * 문제 번호: (2193)
 * 문제 이름: (이친수)
 * 소요 시간(분): (12)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = LongArray(n + 1)
    if (n > 2) {
        dp[1] = 1
        dp[2] = 1
        for (i in 3 until n + 1) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        println(dp[n])
    } else {
        println(1)
    }
}