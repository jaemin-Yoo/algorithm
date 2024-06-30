package boj.implementation

/**
 * 문제 번호: (1205)
 * 문제 이름: (등수 구하기)
 * 소요 시간(분): (11)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, score, p) = br.readLine().split(' ').map { it.toInt() }

    var rank = 1
    if (n > 0) {
        val scores = br.readLine().split(' ').map { it.toInt() }
        for (i in 0 until min(n, p)) {
            if (scores[i] > score) {
                rank++
            } else {
                break
            }
        }

        if (n >= p && scores[p - 1] >= score) {
            rank = -1
        }
    }
    println(rank)
}