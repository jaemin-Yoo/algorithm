package boj.Greedy

import java.util.PriorityQueue
import java.lang.Integer.max

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (start, end) = readln().split(" ").map{ it.toInt() }
        list.add(start to end)
    }
    list.sortBy { it.first }

    val pq = PriorityQueue<Int>()
    var result = 0
    for ((start, end) in list) {
        while (pq.isNotEmpty() && start >= pq.peek()) {
            pq.poll()
        }
        pq.add(end)
        result = max(result, pq.size)
    }
    println(result)
}