package boj.two_pointer

/**
 * 문제 번호: (2467)
 * 문제 이름: (용액)
 * 소요 시간(분): (13)
 */

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    var start = 0
    var end = arr.lastIndex
    var sum = Int.MAX_VALUE
    var result = -1 to -1
    while (start < end) {
        val s = arr[start] + arr[end]
        if (abs(s) < sum) {
            sum = abs(s)
            result = arr[start] to arr[end]
        }

        if (s < 0) {
            start++
        } else {
            end--
        }
    }

    println("${result.first} ${result.second}")
    close()
}