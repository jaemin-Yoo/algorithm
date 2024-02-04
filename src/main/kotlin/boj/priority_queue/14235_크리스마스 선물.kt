package boj.priority_queue

/**
 * 문제 번호: (14235)
 * 문제 이름: (크리스마스 선물)
 * 소요 시간(분): (8)
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(reverseOrder())
    repeat(n) {
        val input = readLine().trim().split(" ").map { it.toInt() }
        if (input[0] == 0) {
            val result = if (pq.isNotEmpty()) {
                pq.poll()
            } else {
                -1
            }
            println(result)
            return@repeat
        }
        for (i in 1 until input[0] + 1) {
            pq.add(input[i])
        }
    }
    close()
}