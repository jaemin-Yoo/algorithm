package boj.binary_search

/**
 * 문제 번호: (2343)
 * 문제 이름: (기타 레슨)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val arr = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val result = binarySearch(arr, m)
    println(result)
}

private fun binarySearch(arr: IntArray, target: Int): Int {
    val sum = arr.sum()
    var start = max(sum / target, arr.maxOf { it })
    var end = sum
    var result = Int.MAX_VALUE
    while (start <= end) {
        val mid = (start + end) / 2
        var s = 0
        var cnt = 1
        arr.forEach { x ->
            s += x
            if (s > mid) {
                s = x
                cnt++
            }
        }
        if (cnt > target) {
            start = mid + 1
        } else {
            end = mid - 1
            result = mid
        }
    }
    return result
}