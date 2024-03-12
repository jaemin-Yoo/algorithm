package boj.dynamic_programming

/**
 * 문제 번호: (1309)
 * 문제 이름: (동물원)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = Array(n) { IntArray(3) }
    dp[0][0] = 1
    dp[0][1] = 1
    dp[0][2] = 1
    for (i in 1 until n) {
        dp[i][0] = dp[i - 1][1] + dp[i - 1][2] % 9901
        dp[i][1] = dp[i - 1][0] + dp[i - 1][2] % 9901
        dp[i][2] = dp[i - 1][0]+ dp[i - 1][1] + dp[i - 1][2] % 9901
    }
    println((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901)
    close()
}