package boj.priority_queue

/**
 * 문제 번호: (14427)
 * 문제 이름: (수열과 쿼리 15)
 * 소요 시간(분): (16:43 ~ )
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.second != b.second) {
            a.second - b.second
        } else {
            a.first - b.first
        }
    }
    val arr = IntArray(n + 1)
    val list = readLine().split(" ").map { it.toInt() }
    for (i in list.indices) {
        arr[i + 1] = list[i]
        pq.add(i + 1 to list[i])
    }

    val m = readLine().toInt()
    repeat(m) {
        val q = readLine()
        if (q == "2") {
            while (pq.isNotEmpty()) {
                val (i, v) = pq.peek()
                if (arr[i] != v) {
                    pq.poll()
                } else {
                    println(i)
                    break
                }
            }
        } else {
            val (_, i, v) = q.split(" ").map { it.toInt() }
            arr[i] = v
            pq.add(i to v)
        }
    }
    close()
}