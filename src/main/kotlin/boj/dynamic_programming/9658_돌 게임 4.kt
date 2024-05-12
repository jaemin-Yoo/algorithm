package boj.dynamic_programming

/**
 * 문제 번호: (9658)
 * 문제 이름: (돌 게임 4)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(1005)
    dp[1] = 0
    dp[2] = 1
    dp[3] = 0
    dp[4] = 1
    dp[5] = 1
    for (i in 6 until n + 1) {
        if (dp[i - 1] + dp[i - 3] + dp[i - 4] == 3) {
            dp[i] = 0
        } else {
            dp[i] = 1
        }
    }
    val result = if (dp[n] == 1) {
        "SK"
    } else {
        "CY"
    }
    print(result)
}