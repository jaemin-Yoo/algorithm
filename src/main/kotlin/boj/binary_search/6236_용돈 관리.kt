package boj.binary_search

/**
 * 문제 번호: (6236)
 * 문제 이름: (용돈 관리)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val costs = IntArray(n)
    var minCost = 0
    var maxCost = 0
    repeat(n) {
        val cost = readLine().toInt()
        if (cost > minCost) {
            minCost = cost
        }
        maxCost += cost
        costs[it] = cost
    }

    val result = binarySearch(costs, maxCost, minCost, m)
    println(result)
    close()
}

private fun binarySearch(costs: IntArray, maxCost: Int, minCost: Int, m: Int): Int {
    var start = minCost
    var end = maxCost
    var result = 0
    while (start <= end) {
        var total = 0
        var cnt = 0
        val mid = (start + end) / 2
        costs.forEach { cost ->
            total += cost
            if (mid == total) {
                total = 0
                cnt++
            } else if (mid < total) {
                total = cost
                cnt++

                if (cost == mid) {
                    total = 0
                    cnt++
                }
            }
        }
        if (total > 0) {
            total = 0
            cnt++
        }

        if (cnt > m) {
            start = mid + 1
        } else {
            result = mid
            end = mid - 1
        }
    }

    return result
}