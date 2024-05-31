private const val MAX_SIZE = 100
private const val MOD = 1_000_000_000

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = Array(MAX_SIZE + 1) { LongArray(10) }
    for (i in 1 until 10) {
        dp[1][i] = 1
    }
    for (i in 2 until MAX_SIZE + 1) {
        dp[i][0] = dp[i - 1][1] % MOD
        for (j in 1 until 9) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD
        }
        dp[i][9] = dp[i - 1][8] % MOD
    }
    println(dp[n].sum() % MOD)
}
