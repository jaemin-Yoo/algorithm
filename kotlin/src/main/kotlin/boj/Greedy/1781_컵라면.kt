package boj.Greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (d, r) = readLine().split(" ").map{ it.toInt() }
        list.add(d to r)
    }
    list.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second } )

    var day = 1
    val pq = PriorityQueue<Int>()
    for ((d, r) in list) {
        if (pq.isEmpty()) {
            pq.add(r)
            continue
        }

        if (d == day && pq.isNotEmpty() && r > pq.peek()) {
            pq.poll()
            pq.add(r)
        } else if (d > day) {
            day += 1
            pq.add(r)
        }
    }
    println(pq.sum())
    close()
}