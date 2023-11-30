package boj.Dijkstra.파티1238

import java.util.Queue
import java.util.LinkedList
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, x) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distances = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
    repeat(m) {
        val (s, e, t) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e to t)
    }

    for (i in 1 until n + 1) {
        dijkstra(i, distances, graph)
    }

    var answer = 0
    for (i in 1 until n + 1) {
        answer = max(answer, distances[i][x] + distances[x][i])
    }
    println(answer)

    close()
}

private fun dijkstra(start: Int, distances: Array<IntArray>, graph: Array<MutableList<Pair<Int, Int>>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    distances[start][start] = 0

    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()

        if (distances[start][x] < dist) continue

        graph[x].forEach { (n, d) ->
            val newDist = dist + d
            if (distances[start][n] > newDist) {
                distances[start][n] = newDist
                q.add(n to newDist)
            }
        }
    }
}