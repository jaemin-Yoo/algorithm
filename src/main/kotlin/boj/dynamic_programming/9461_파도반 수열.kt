package boj.dynamic_programming

/**
 * 문제 번호: (9461)
 * 문제 이름: (파도반 수열)
 * 소요 시간(분): (0106 ~ )
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = LongArray(101)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    for (i in 4 until 101) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }
    repeat(t) {
        val n = br.readLine().toInt()
        println(dp[n])
    }
}