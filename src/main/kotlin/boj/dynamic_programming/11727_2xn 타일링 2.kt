package boj.dynamic_programming

/**
 * 문제 번호: (11727)
 * 문제 이름: (2xn 타일링 2)
 * 소요 시간(분): (8)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(1001)
    dp[1] = 1
    dp[2] = 3
    for (i in 3 until 1001) {
        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007
    }
    println(dp[n] % 10007)
}