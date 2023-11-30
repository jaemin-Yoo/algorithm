package boj.Greedy

import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (n, m) = readln().split(" ").map{ it.toInt() }
        val students = mutableListOf<Pair<Int, Int>>()
        repeat(m) {
            val (a, b) = readln().split(" ").map{ it.toInt() }
            students.add(a to b)
        }

        var cnt = 0
        val pq = PriorityQueue<Int>()
        for (i in 1 until n + 1) {
            val filter = students.filter { (a, _) -> a == i }.map { (_, b) -> b }
            pq.addAll(filter)

            while (pq.isNotEmpty()) {
                val book = pq.poll()
                if (book >= i) {
                    cnt += 1
                    break
                }
            }
        }
        println(cnt)
    }
}