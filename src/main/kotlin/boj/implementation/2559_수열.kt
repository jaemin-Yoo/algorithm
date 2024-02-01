package boj.implementation

/**
 * 문제 번호: (2559)
 * 문제 이름: (수열)
 * 소요 시간(분): (12)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    val pArr = IntArray(n + 1)
    for (i in 1 until n + 1) {
        pArr[i] = arr[i - 1] + pArr[i - 1]
    }

    var result = Int.MIN_VALUE
    for (i in k until n + 1) {
        result = max(result, pArr[i] - pArr[i - k])
    }
    println(result)
    close()
}