package boj.binary_search

/**
 * 문제 번호: (16401)
 * 문제 이름: (과자 나눠주기)
 * 소요 시간(분): (26)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val snacks = readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val result = binarySearch(snacks, m)
    println(result)
    close()
}

private fun binarySearch(snacks: IntArray, nCnt: Int): Int {
    var start = 1
    var end = snacks.last()
    var result = 0
    while (start <= end) {
        val mid = (start + end) / 2
        if (getCountSnack(snacks, mid) >= nCnt) {
            start = mid + 1
            result = mid
        } else {
            end = mid - 1
        }
    }
    return result
}

private fun getCountSnack(snacks: IntArray, snackLength: Int): Int {
    var cnt = 0
    for (i in snacks.lastIndex downTo 0) {
        cnt += snacks[i] / snackLength
    }
    return cnt
}