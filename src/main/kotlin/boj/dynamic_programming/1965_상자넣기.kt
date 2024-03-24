package boj.dynamic_programming

/**
 * 문제 번호: (1965)
 * 문제 이름: (상자넣기)
 * 소요 시간(분): (9)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val boxes = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n)
    dp[0] = 1
    for (i in 1 until n) {
        var maxCount = 0
        for (j in 0 until i) {
            if (boxes[j] < boxes[i]) {
                maxCount = max(maxCount, dp[j])
            }
        }
        dp[i] = maxCount + 1
    }
    println(dp.maxOf { it })
    close()
}