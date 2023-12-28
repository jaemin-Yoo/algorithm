package boj.two_pointer

/**
 * 문제 번호: (2470)
 * 문제 이름: (두 용액)
 * 소요 시간(분): (15)
 */

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val sortedArr = arr.sorted()
    var start = 0
    var end = arr.lastIndex
    var minWater = Int.MAX_VALUE
    var result = -1 to -1
    while (start < end) {
        val a = sortedArr[start]
        val b = sortedArr[end]
        val newWater = abs(a + b)
        if (minWater > newWater) {
            minWater = newWater
            result = a to b
        }

        if (a + b > 0) {
            end--
        } else {
            start++
        }
    }
    println("${result.first} ${result.second}")

    close()
}