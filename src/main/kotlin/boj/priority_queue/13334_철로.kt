package boj.priority_queue

/**
 * 문제 번호: (13334)
 * 문제 이름: (철로)
 * 소요 시간(분): (x)
 */

import java.util.PriorityQueue
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val roads = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (h, o) = readLine().split(" ").map { it.toInt() }
        val p = if (h > o) {
            o to h
        } else {
            h to o
        }
        roads.add(p)
    }
    val d = readLine().toInt()
    roads.sortBy { it.second }

    var result = 0
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.first == b.first) {
            a.second - b.second
        } else {
            a.first - b.first
        }
    }
    for (road in roads) {
        val (start, end) = road
        if (end - start > d) continue

        while (pq.isNotEmpty() && pq.peek().first < end - d) {
            pq.poll()
        }
        pq.add(road)
        result = max(result, pq.size)
    }
    println(result)

    close()
}