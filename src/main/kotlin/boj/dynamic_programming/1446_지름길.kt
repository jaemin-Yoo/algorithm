package boj.dynamic_programming

/**
 * 문제 번호: (1446)
 * 문제 이름: (지름길)
 * 소요 시간(분): (21)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, d) = br.readLine().split(' ').map { it.toInt() }
    val dp = IntArray(d + 1) { it }
    val map = HashMap<Int, MutableList<Pair<Int, Int>>>()
    repeat(n) {
        val (s, e, sd) = br.readLine().split(' ').map { it.toInt() }
        if (!map.containsKey(e)) {
            map[e] = mutableListOf()
        }
        map[e]!!.add(s to sd)
    }

    for (i in 1 until d + 1) {
        dp[i] = dp[i - 1] + 1

        if (map.containsKey(i)) {
            map[i]?.forEach { (s, sd) ->
                dp[i] = min(dp[s] + sd, dp[i])
            }
        }
    }
    println(dp[d])
}