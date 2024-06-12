package boj.dynamic_programming

/**
 * 문제 번호: (2293)
 * 문제 이름: (동전 1)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val coins = mutableListOf<Int>()
    repeat(n) {
        val c = br.readLine().toInt()
        coins.add(c)
    }
    val dp = Array(n) { IntArray(k + 1) }
    dp[0][0] = 1
    for (j in 1 until k + 1) {
        if (j % coins[0] == 0) {
            dp[0][j] = 1
        }
    }

    for (i in 1 until n) {
        for (j in 0 until k + 1) {
            if (j < coins[i]) {
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]
            }
        }
    }
    println(dp[n - 1][k])
}