package boj.dynamic_programming

/**
 * 문제 번호: (9095)
 * 문제 이름: (1, 2, 3 더하기)
 * 소요 시간(분): (10)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = IntArray(11)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4 until 11) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(dp[n])
    }
}