package boj.Dynamic_Programming.동전1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1)
    dp[0] = 1
    repeat(n) {
        val c = readLine().toInt()
        for (i in c until k + 1) {
            dp[i] += dp[i - c]
        }
    }
    print(dp[k])

    close()
}