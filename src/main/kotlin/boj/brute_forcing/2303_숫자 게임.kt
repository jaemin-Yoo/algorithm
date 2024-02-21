package boj.brute_forcing

/**
 * 문제 번호: (2303)
 * 문제 이름: (숫자 게임)
 * 소요 시간(분): (9)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val players = IntArray(n + 1)
    for (idx in 1 until n + 1) {
        val cards = readLine().split(" ").map { it.toInt() }
        var mx = 0
        for (i in 0 until 5) {
            for (j in i + 1 until 5) {
                for (k in j + 1 until 5) {
                    mx = max(mx, (cards[i] + cards[j] + cards[k]) % 10)
                }
            }
        }
        players[idx] = mx
    }
    val maxNum = players.maxOf { it }
    val result = players.indexOfLast { it == maxNum }
    println(result)
    close()
}