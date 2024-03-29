package boj.two_pointer

/**
 * 문제 번호: (22857)
 * 문제 이름: (가장 긴 짝수 연속한 부분 수열 (small))
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }
    var oddCnt = 0
    var evenCnt = 0
    var start = 0
    var end = 0
    var result = 0
    while (end in start until n) {
        if (arr[end] % 2 == 1) {
            oddCnt++
        } else {
            evenCnt++
        }

        while (k < oddCnt) {
            if (arr[start] % 2 == 1) {
                oddCnt--
            } else {
                evenCnt--
            }
            start++
        }

        result = max(result, evenCnt)
        end++
    }
    println(result)
    close()
}