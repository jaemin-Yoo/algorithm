package boj.Dijkstra.최소비용구하기

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    repeat(m) {
        val (s ,e, dist) = readLine().split(" ").map { it.toInt() }
        graph[s].add(e to dist)
    }
    val (start, end) = readLine().split(" ").map { it.toInt() }
    dijkstra(start, distances, graph)
    println(distances[end])
    close()
}

private fun dijkstra(start: Int, distances: IntArray, graph: Array<MutableList<Pair<Int, Int>>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    distances[start] = 0
    while (q.isNotEmpty()) {
        val (node, dist) = q.poll()

        if (distances[node] < dist) continue

        graph[node].forEach { (nextNode, nextDist) ->
            val newDist = dist + nextDist
            if (distances[nextNode] > newDist) {
                distances[nextNode] = newDist
                q.add(nextNode to newDist)
            }
        }
    }
}