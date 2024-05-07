package boj.dijkstra

/**
 * 문제 번호: (1238)
 * 문제 이름: (파티)
 * 소요 시간(분): (23)
 */

import java.util.PriorityQueue
import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m, x) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, t) = br.readLine().split(' ').map { it.toInt() }
        graph[a].add(b to t)
    }

    var result = 0
    for (i in 1 until n + 1) {
        if (x != i) {
            val travelTime = dijkstra(graph, i, x, n)
            val returnTime = dijkstra(graph, x, i, n)
            result = max(result, travelTime + returnTime)
        }
    }
    println(result)
}

private fun dijkstra(graph: Array<MutableList<Pair<Int, Int>>>, start: Int, end: Int, n: Int): Int {
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second}
    val times = IntArray(n + 1) { Int.MAX_VALUE }
    pq.add(start to 0)
    times[start] = 0

    while (pq.isNotEmpty()) {
        val (a, t) = pq.poll()
        if (times[a] < t) continue

        graph[a].forEach { (next, time) ->
            val newTime = t + time
            if (times[next] > newTime) {
                times[next] = newTime
                pq.add(next to newTime)
            }
        }
    }

    return times[end]
}