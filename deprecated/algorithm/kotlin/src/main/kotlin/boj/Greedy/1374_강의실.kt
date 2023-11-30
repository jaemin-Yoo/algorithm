package boj.Greedy.강의실1374

import kotlin.math.max
import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val classList = mutableListOf<Pair<Int, Int>>()
    val pq = PriorityQueue<Int>()
    repeat(n) {
        val (_, start, end) = readLine().split(" ").map { it.toInt() }
        classList.add(start to end)
    }
    classList.sortBy { it.first }

    var result = 0
    classList.forEach { (start, end) ->
        while (pq.isNotEmpty() && pq.peek() <= start) {
            pq.poll()
        }
        pq.add(end)
        result = max(result, pq.size)
    }
    println(result)

    close()
}