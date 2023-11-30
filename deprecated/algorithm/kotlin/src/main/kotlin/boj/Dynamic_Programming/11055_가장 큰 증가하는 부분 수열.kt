package boj.Dynamic_Programming.가장큰증가하는부분수열11055

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n).mapIndexed { index, _ -> list[index] }.toIntArray()

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (list[i] > list[j]) {
                dp[i] = max(dp[i], list[i] + dp[j])
            }
        }
    }
    println(dp.maxOf { it })

    close()
}