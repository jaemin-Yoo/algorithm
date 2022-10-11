package boj.Depth_first_Search

import java.util.*

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(n) {
        val row = readln().split(" ").map { it.toInt() }
        for (i in row) {
            pq.add(i)
        }
    }
    repeat(n - 1) { pq.poll() }
    println(pq.peek())
}