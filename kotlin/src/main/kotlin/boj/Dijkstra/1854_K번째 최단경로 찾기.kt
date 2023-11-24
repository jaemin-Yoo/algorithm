package boj.Dijkstra.K번째최단경로찾기1854

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distances = Array(n + 1) { IntArray(k + 1) { Int.MAX_VALUE } }
    for (i in 1 until n + 1) {
        distances[i][0] = -1
    }
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to c)
    }
    dijkstra(k, distances, graph)
    for (i in 1 until n + 1) {
        val dist = distances[i][k]
        val answer = if (dist == Int.MAX_VALUE) {
            -1
        } else {
            dist
        }
        println(answer)
    }
    close()
}

private fun dijkstra(k: Int, distances: Array<IntArray>, graph: Array<MutableList<Pair<Int, Int>>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(1 to 0)
    distances[1][1] = 0

    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()

        graph[x].forEach { (n, d) ->
            val newDist = dist + d
            if (distances[n][k] > newDist) {
                distances[n][k] = newDist
                distances[n].sort()
                q.add(n to newDist)
            }
        }
    }
}