package boj.implementation

/**
 * 문제 번호: (1205)
 * 문제 이름: (등수 구하기)
 * 소요 시간(분): (25)
 */

import java.util.PriorityQueue
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, score, p) = readLine().split(" ").map { it.toInt() }
    if (n == 0) {
        println(1)
        return@with
    }
    val scores = readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Int>(reverseOrder())
    var rank = 1
    for (i in 0 until min(n, p)) {
        val s = scores[i]
        pq.add(s)
    }
    pq.add(score)

    var result = -1
    while (pq.isNotEmpty()) {
        val x = pq.poll()
        val r = rank
        while (x == pq.peek()) {
            pq.poll()
            rank++
        }
        if (x == score && rank <= p) {
            result = r
            break
        }

        rank++
    }
    println(result)
    close()
}