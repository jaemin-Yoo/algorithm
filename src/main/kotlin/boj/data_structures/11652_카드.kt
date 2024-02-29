package boj.data_structures

/**
 * 문제 번호: (11652)
 * 문제 이름: (카드)
 * 소요 시간(분): (10)
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = HashMap<Long, Int>()
    repeat(n) {
        val card = readLine().toLong()
        if (map.containsKey(card)) {
            map[card] = map[card]!! + 1
        } else {
            map[card] = 1
        }
    }

    val maxCount = map.maxOf { it.value }
    val pq = PriorityQueue<Long>()
    for ((k, v) in map) {
        if (v == maxCount) {
            pq.add(k)
        }
    }
    println(pq.poll())

    close()
}