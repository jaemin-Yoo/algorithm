package boj.binary_search

/**
 * 문제 번호: (1072)
 * 문제 이름: (게임)
 * 소요 시간(분): (22)
 */

import kotlin.math.ceil

fun main() = System.`in`.bufferedReader().use { br ->
    val (x, y) = br.readLine().split(' ').map { it.toLong() }
    val a = 100L * y / x + 1
    if (a >= 100) {
        println(-1)
    } else {
        println(ceil((a * x - 100.0 * y) / (100 - a)).toLong())
    }
}