package boj.dynamic_programming

/**
 * 문제 번호: (1932)
 * 문제 이름: (정수 삼각형)
 * 소요 시간(분): (6)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = Array(n) { IntArray(n) }
    repeat(n) { x ->
        val a = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        a.forEachIndexed { y, v ->
            dp[x][y] = if (x == 0) {
                v
            } else if (y == 0) {
                dp[x - 1][y] + v
            } else {
                max(dp[x - 1][y - 1], dp[x - 1][y]) + v
            }
        }
    }
    println(dp[n - 1].maxOf { it })
}