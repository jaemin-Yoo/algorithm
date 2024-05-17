package boj.dynamic_programming

/**
 * 문제 번호: (1003)
 * 문제 이름: (피보나치 함수)
 * 소요 시간(분): (13)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val dp = Array(41) { 0 to 0 }
    dp[0] = 1 to 0
    dp[1] = 0 to 1
    for (i in 2 until 41) {
        dp[i] = dp[i - 1].first + dp[i - 2].first to dp[i - 1].second + dp[i - 2].second
    }
    repeat(t) {
        val n = br.readLine().toInt()
        val (a, b) = dp[n]
        println("$a $b")
    }
}