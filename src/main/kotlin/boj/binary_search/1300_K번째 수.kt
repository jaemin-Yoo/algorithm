package boj.binary_search

/**
 * 문제 번호: (1300)
 * 문제 이름: (K번째 수)
 * 소요 시간(분): (x)
 */

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    val result = binarySearch(n, k)
    println(result)

    close()
}

private fun binarySearch(n: Int, k: Int): Int {
    var start = 0
    var end = k
    var mid = k / 2
    var ans = mid
    while (start <= end) {
        mid = (start + end) / 2
        val cnt = getCount(n, mid)
        if (cnt >= k) {
            ans = mid
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return ans
}

private fun getCount(n: Int, x: Int): Int {
    var cnt = 0
    for (i in 1 until n + 1) {
        cnt += min(x / i, n)
    }
    return cnt
}