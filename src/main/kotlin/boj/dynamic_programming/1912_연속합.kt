package boj.dynamic_programming

/**
 * 문제 번호: (1912)
 * 문제 이름: (연속합)
 * 소요 시간(분): (10)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val a = br.readLine().split(' ').map { it.toInt() }
    val dp = IntArray(n)
    a.forEachIndexed { index, v ->
        dp[index] = if (index == 0) {
            v
        } else {
            max(dp[index - 1], 0) + v
        }
    }
    println(dp.maxOf { it })
}