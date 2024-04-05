package boj.topological_sorting

/**
 * 문제 번호: (16169)
 * 문제 이름: (수행시간)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val ranks = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n) { i ->
        val (r, t) = br.readLine().split(' ').map { it.toInt() }
        ranks[r].add(i + 1 to t)
    }
    val dp = IntArray(n + 1)
    dfs(ranks, dp, 1, null, 0, n)

    println(dp.maxOf { it })
}

private fun dfs(
    ranks: Array<MutableList<Pair<Int, Int>>>,
    dp: IntArray,
    rank: Int,
    prevNum: Int?,
    totalDelay: Int,
    n: Int
) {
    if (rank > n || ranks[rank].isEmpty()) return

    ranks[rank].forEach { (num, delay) ->
        val newDelay = if (prevNum == null) {
            delay
        } else {
            (prevNum - num) * (prevNum - num) + totalDelay + delay
        }

        if (dp[num] <= newDelay) {
            dp[num] = newDelay
            dfs(ranks, dp, rank + 1, num, newDelay, n)
        }
    }
}