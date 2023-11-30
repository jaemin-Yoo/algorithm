package boj.Dynamic_Programming.제곱수의합1699

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dp = IntArray(n + 1) { it }

    for (i in 1 until n + 1) {
        for (j in 1 until i) {
            if (i < j * j) break

            if (dp[i] > dp[i - j * j] + 1) {
                dp[i] = dp[i - j * j] + 1
            }
        }
    }

    println(dp[n])

    close()
}