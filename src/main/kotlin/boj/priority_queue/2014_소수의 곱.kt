package boj.priority_queue

/**
 * 문제 번호: (2014)
 * 문제 이름: (소수의 곱)
 * 소요 시간(분): (x)
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (k, n) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toLong() }
    val pq = PriorityQueue<Long>()
    for (i in 0 until k) {
        pq.add(arr[i])
    }

    repeat(n - 1) {
        val x = pq.poll()
        for (i in 0 until k) {
            val v = arr[i] * x
            pq.add(v)

            if (x % arr[i] == 0L) break
        }
    }
    println(pq.poll())

    close()
}