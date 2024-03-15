package boj.binary_search

/**
 * 문제 번호: (2417)
 * 문제 이름: (정수 제곱근)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    val result = binarySearch(n)
    println(result)
    close()
}

private fun binarySearch(n: Long): Long {
    var start = 0L
    var end = n
    var result = 0L
    while (start <= end) {
        val mid = (start + end) / 2
        if (mid.toDouble() * mid.toDouble() >= n) {
            result = mid
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return result
}