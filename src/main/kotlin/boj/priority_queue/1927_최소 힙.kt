package boj.priority_queue

/**
 * 문제 번호: (1927)
 * 문제 이름: (최소 힙)
 * 소요 시간(분): (4)
 */

import java.util.PriorityQueue

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()
    val sb = StringBuilder()
    repeat(n) {
        val x = br.readLine().toInt()
        if (x == 0) {
            val result = if (pq.isEmpty()) {
                0
            } else {
                pq.poll()
            }
            sb.appendLine(result)
        } else {
            pq.add(x)
        }
    }
    print(sb)
}