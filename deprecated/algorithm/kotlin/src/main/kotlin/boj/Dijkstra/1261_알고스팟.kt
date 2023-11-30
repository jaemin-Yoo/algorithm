package boj.Dijkstra.알고스팟1261

import java.util.LinkedList
import java.util.Queue

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<String>()
    val distances = Array(n) { IntArray(m + 1) { Int.MAX_VALUE } }
    repeat(n) {
        val row = readLine()
        graph.add(row)
    }
    dijkstra(n, m, distances, graph)
    println(distances[n - 1][m - 1])
    close()
}

private fun dijkstra(n: Int, m: Int, distances: Array<IntArray>, graph: MutableList<String>) {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    q.add(Triple(0, 0, 0))
    distances[0][0] = 0

    while (q.isNotEmpty()) {
        val (x, y, dist) = q.poll()

        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]

            if (a !in 0 until n || b !in 0 until m) continue

            val newDist = if (graph[a][b] == '1') {
                dist + 1
            } else {
                dist
            }
            if (distances[a][b] > newDist) {
                distances[a][b] = newDist
                q.add(Triple(a, b, newDist))
            }
        }
    }
}