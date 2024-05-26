package boj.dynamic_programming

/**
 * 문제 번호: (2156)
 * 문제 이름: (포도주 시식)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    val lst = mutableListOf(0)
    repeat(n) {
        val a = br.readLine().toInt()
        lst.add(a)
    }
    if (n == 1) {
        println(lst[1])
    } else {
        dp[1] = lst[1]
        dp[2] = dp[1] + lst[2]
        for (i in 3 until n + 1) {
            dp[i] = max(max(dp[i - 3] + lst[i - 1] + lst[i], dp[i - 2] + lst[i]), dp[i - 1])
        }
        println(dp[n])
    }
}