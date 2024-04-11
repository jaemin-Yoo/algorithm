package boj.binary_search

/**
 * 문제 번호: (15810)
 * 문제 이름: (풍선 공장)
 * 소요 시간(분): (31)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val a = br.readLine().split(' ').map { it.toInt() }
    val result = binarySearch(a, m.toLong())
    println(result)
}

private fun binarySearch(a: List<Int>, m: Long): Long {
    var start = 1L
    var end = a.minOf { it } * m
    var result = 0L
    while (start <= end) {
        val mid = (start + end) / 2L
        val cnt = a.fold(0L) { total, num -> total + mid / num }
        if (cnt < m) {
            start = mid + 1
        } else {
            result = mid
            end = mid - 1
        }
    }
    return result
}