package boj.binary_search

/**
 * 문제 번호: (2512)
 * 문제 이름: (예산)
 * 소요 시간(분): (19)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val m = br.readLine().toInt()
    val result = binarySearch(arr, n, m)
    println(result)
}

private fun binarySearch(arr: IntArray, n: Int, m: Int): Int {
    var start = m / n
    var end = arr.max()
    var result = arr.sum()
    while (start <= end) {
        val mid = (start + end) / 2
        val newArr = arr.map { min(it, mid) }
        if (newArr.sum() <= m) {
            start = mid + 1
            result = newArr.max()
        } else {
            end = mid - 1
        }
    }
    return result
}