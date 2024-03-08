package boj.priority_queue

/**
 * 문제 번호: (23757)
 * 문제 이름: (아이들과 선물 상자)
 * 소요 시간(분): (6)
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val pq = PriorityQueue<Int>(reverseOrder())
    val giftBoxes = readLine().split(" ").map { it.toInt() }
    val children = readLine().split(" ").map { it.toInt() }
    giftBoxes.forEach {
        pq.add(it)
    }

    var result = 1
    children.forEach {
        val cnt = pq.poll()
        if (cnt < it) {
            result = 0
            return@forEach
        }

        pq.add(cnt - it)
    }
    println(result)
    close()
}