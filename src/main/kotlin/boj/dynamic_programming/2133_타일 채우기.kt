package boj.dynamic_programming

/**
 * 문제 번호: (2133)
 * 문제 이름: (타일 채우기)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n / 2 + 1)

    val answer = if (n % 2 == 1) {
        0
    } else {
        dp[1] = 3

        for (i in 4 until n + 1 step 2) {
            dp[i / 2] = dp[i / 2 - 1] * dp[1]
            for (j in 2 until i - 4 + 1 step 2) {
                dp[i / 2] += dp[j / 2] * 2
            }
            dp[i / 2] += 2
        }

        dp[n / 2]
    }
    println(answer)
    close()
}