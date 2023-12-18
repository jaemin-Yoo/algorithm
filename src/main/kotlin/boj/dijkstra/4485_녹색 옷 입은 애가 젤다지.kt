package boj.dijkstra

/**
 * 문제 번호: (4485)
 * 문제 이름: (녹색 옷 입은 애가 젤다지)
 * 소요 시간(분): (13)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    var round = 1
    while (true) {
        val n = readLine().toInt()
        if (n == 0) return

        val distances = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        val graph = mutableListOf<List<Int>>()
        repeat(n) {
            val row = readLine().split(" ").map { it.toInt() }
            graph.add(row)
        }

        dijkstra(n, distances, graph)
        val result = distances[n - 1][n - 1]
        println("Problem $round: $result")
        round += 1
    }
}

private fun dijkstra(n: Int, distances: Array<IntArray>, graph: MutableList<List<Int>>) {
    val q: Queue<Triple<Int, Int ,Int>> = LinkedList()
    q.add(Triple(0, 0, graph[0][0]))
    distances[0][0] = graph[0][0]

    while (q.isNotEmpty()) {
        val (x, y, dist) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]

            if (a in 0 until n && b in 0 until n) {
                val newDist = dist + graph[a][b]
                if (distances[a][b] > newDist) {
                    distances[a][b] = newDist
                    q.add(Triple(a, b, newDist))
                }
            }
        }
    }
}