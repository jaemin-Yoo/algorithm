package boj.dijkstra

/**
 * 문제 번호: (1719)
 * 문제 이름: (택배)
 * 소요 시간(분): (x)
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(m) {
        val (a, b, dist) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to dist)
        graph[b].add(a to dist)
    }

    for (i in 1 until n + 1) {
        val distances = IntArray(n + 1) { Int.MAX_VALUE }
        val nodes = IntArray(n + 1) { Int.MAX_VALUE }
        dijkstra(graph, distances, nodes, i)

        val result = mutableListOf<String>()
        for (j in 1 until n + 1) {
            if (i == j) {
                result.add("-")
            } else {
                result.add(nodes[j].toString())
            }
        }
        println(result.joinToString(" "))
    }
    close()
}

private fun dijkstra(graph: Array<MutableList<Pair<Int, Int>>>, distances: IntArray, nodes: IntArray, start: Int) {
    val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b->
        a.second - b.second
    }
    distances[start] = 0
    nodes[start] = start

    graph[start].forEach { (x, dist) ->
        pq.add(Triple(x, dist, x))
        distances[x] = dist
        nodes[x] = x
    }

    while (pq.isNotEmpty()) {
        val (x, dist, node) = pq.poll()
        if (distances[x] < dist) continue

        graph[x].forEach { (a, d) ->
            val newDist = dist + d
            if (distances[a] > newDist) {
                distances[a] = newDist
                nodes[a] = node
                pq.add(Triple(a, newDist, node))
            }
        }
    }
}