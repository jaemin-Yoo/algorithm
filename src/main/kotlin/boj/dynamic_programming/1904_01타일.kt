package boj.dynamic_programming

/**
 * 문제 번호: (1904)
 * 문제 이름: (01타일)
 * 소요 시간(분): (x)
 */
private const val MAX_SIZE = 1_000_000

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(MAX_SIZE + 1)
    dp[1] = 1
    dp[2] = 2
    for (i in 3 until MAX_SIZE + 1) {
        dp[i] = dp[i - 2] + dp[i - 1]
    }
    println(dp[n])
}