package boj.priority_queue

/**
 * 문제 번호: (29160)
 * 문제 이름: (나의 FIFA 팀 가치는?)
 * 소요 시간(분): (15)
 */

import java.util.PriorityQueue
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<Int, PriorityQueue<Int>>()
    for (i in 1..11) {
        map[i] = PriorityQueue(reverseOrder())
    }

    repeat(n) {
        val (p, w) = readLine().split(" ").map { it.toInt() }
        map[p]!!.add(w)
    }

    repeat(k) {
        for (i in 1..11) {
            map[i]?.let { pq ->
                if (pq.isNotEmpty()) {
                    val w = pq.poll()
                    pq.add(max(w - 1, 0))
                }
            }
        }
    }

    var result = 0
    for (i in 1..11) {
        map[i]?.let { pq ->
            if (pq.isNotEmpty()) {
                result += pq.poll()
            }
        }
    }
    println(result)

    close()
}