package boj.priority_queue

/**
 * 문제 번호: (2075)
 * 문제 이름: (N번째 큰 수)
 * 소요 시간(분): (4)
 */

import java.util.PriorityQueue
import java.util.Collections

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(n) {
        br.readLine().split(' ').map { pq.add(it.toInt()) }
    }
    var result = 0
    repeat(n) {
        result = pq.poll()
    }
    print(result)
}