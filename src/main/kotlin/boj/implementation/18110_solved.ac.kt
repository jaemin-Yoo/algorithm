package boj.implementation

/**
 * 문제 번호: (18110)
 * 문제 이름: (solved.ac)
 * 소요 시간(분): (x)
 */

import kotlin.math.roundToInt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        val a = readLine().toInt()
        list.add(a)
    }
    list.sort()

    val rc = (n * 0.15).roundToInt()
    val avg = list.subList(0 + rc, list.size - rc).average()
    if (avg.isNaN()) {
        println(0)
    } else {
        val result = avg.roundToInt()
        println(result)
    }
    close()
}