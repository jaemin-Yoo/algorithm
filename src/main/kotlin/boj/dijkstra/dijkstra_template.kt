package boj.dijkstra

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    dijkstra(graph, distances)
    println(distances[n])
    close()
}

private fun dijkstra(graph: Array<MutableList<Pair<Int, Int>>>, distances: IntArray) {
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.second - b.second
    }
    pq.add(1 to 0)
    distances[1] = 0

    while (pq.isNotEmpty()) {
        val (x, cost) = pq.poll()
        if (distances[x] < cost) continue

        graph[x].forEach { (a, c) ->
            val newCost = c + cost
            if (distances[a] > newCost) {
                distances[a] = newCost
                pq.add(a to newCost)
            }
        }
    }
}