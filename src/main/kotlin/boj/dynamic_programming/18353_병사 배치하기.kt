package boj.dynamic_programming

/**
 * 문제 번호: (18353)
 * 문제 이름: (병사 배치하기)
 * 소요 시간(분): (9)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val soldiers = br.readLine().split(' ').map { it.toInt() }
    val dp = IntArray(n) { 1 }

    for (i in 1 until n) {
        for (j in 0 until i) {
            if (soldiers[i] < soldiers[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    println(n - dp.maxOf { it })
}