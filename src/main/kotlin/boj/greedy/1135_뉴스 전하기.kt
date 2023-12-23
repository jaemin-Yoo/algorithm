package boj.greedy

/**
 * 문제 번호: (1135)
 * 문제 이름: (뉴스 전하기)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val child = Array(n) { mutableListOf<Int>() }
    val dp = IntArray(n) { -1 }
    for (i in 1 until n) {
        child[list[i]].add(i)
    }

    println(solve(child, dp, 0))
    close()
}

private fun solve(child: Array<MutableList<Int>>, dp: IntArray, idx: Int): Int {
    if (dp[idx] != -1) return dp[idx]
    if (child[idx].isEmpty()) {
        dp[idx] = 0
        return 0
    }

    val curChildCost = mutableListOf<Int>()
    child[idx].forEach { a ->
        val time = solve(child, dp, a)
        curChildCost.add(time)
    }
    curChildCost.sortDescending()

    for (i in curChildCost.indices) {
        curChildCost[i] += i + 1
    }

    val maxTime = curChildCost.maxOrNull() ?: 0
    dp[idx] = maxTime
    return maxTime
}