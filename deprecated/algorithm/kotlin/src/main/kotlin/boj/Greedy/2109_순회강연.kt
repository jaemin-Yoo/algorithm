package boj.Greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (p, d) = readLine().split(" ").map{ it.toInt() }
        list.add(d to p)
    }
    list.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

    var day = 1
    val pq = PriorityQueue<Int>()
    for ((d, p) in list) {
        if (pq.isEmpty()) {
            pq.add(p)
            continue
        }

        if (d > day) {
            day += 1
            pq.add(p)
        } else if (d == day && p > pq.peek()) {
            pq.poll()
            pq.add(p)
        }
    }
    println(pq.sum())
    close()
}