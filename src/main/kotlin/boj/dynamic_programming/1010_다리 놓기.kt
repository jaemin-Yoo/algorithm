package boj.dynamic_programming

/**
 * 문제 번호: (1010)
 * 문제 이름: (다리 놓기)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(' ').map { it.toInt() }

        var top = 1L
        var bottom = 1L
        val r = max(m - n + 1, n + 1)
        for (i in m downTo r) {
            top *= i
        }
        for (j in m - r + 1 downTo 1) {
            bottom *= j
        }

        println(top / bottom)
    }
}