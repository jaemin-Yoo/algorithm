package boj.two_pointer

/**
 * 문제 번호: (1522)
 * 문제 이름: (문자열 교환)
 * 소요 시간(분): (x)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val s = br.readLine()
    val n = s.length
    val aCount = s.count { it == 'a' }
    var bCount = 0
    for (i in 0 until aCount) {
        if (s[i] == 'b') {
            bCount++
        }
    }

    var start = 0
    var end = aCount - 1
    var result = bCount
    while (start < n) {
        if (s[start] == 'b') {
            bCount--
        }
        start += 1
        end = (end + 1) % n
        if (s[end] == 'b') {
            bCount++
        }
        result = min(result, bCount)
    }
    println(result)
}