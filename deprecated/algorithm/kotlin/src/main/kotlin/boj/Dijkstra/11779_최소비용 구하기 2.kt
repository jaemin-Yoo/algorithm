package boj.Dijkstra.최소비용구하기2

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distances = Array(n + 1) { Int.MAX_VALUE to listOf<Int>() }
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to c)
    }
    val (s ,e) = readLine().split(" ").map { it.toInt() }

    dijkstra(s, distances, graph)
    println(distances[e].first)
    println(distances[e].second.size)
    println(distances[e].second.joinToString(" "))
    close()
}

private fun dijkstra(start: Int, distances: Array<Pair<Int, List<Int>>>, graph: Array<MutableList<Pair<Int, Int>>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    distances[start] = 0 to listOf(start)

    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()

        if (distances[x].first < dist) continue

        graph[x].forEach { (n, d) ->
            val newDist = dist + d
            if (distances[n].first > newDist) {
                val newPath = distances[x].second + listOf(n)
                distances[n] = newDist to newPath
                q.add(n to newDist)
            }
        }
    }
}