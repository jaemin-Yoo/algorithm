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
    val dp = IntArray(k + 1)
    dp[0] = 1
    coins.forEach { coin ->
        for (i in coin until k + 1) {
            dp[i] += dp[i - coin]
        }
    }
    println(dp[k])
}