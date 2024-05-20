package boj.dynamic_programming

/**
 * 문제 번호: (11053)
 * 문제 이름: (가장 긴 증가하는 부분 수열)
 * 소요 시간(분): (9)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val a = br.readLine().split(' ').map { it.toInt() }
    val dp = IntArray(n)
    for (i in 0 until n) {
        dp[i] = 1
        for (j in 0 until i) {
            if (a[i] > a[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    println(dp.maxOf { it })
}