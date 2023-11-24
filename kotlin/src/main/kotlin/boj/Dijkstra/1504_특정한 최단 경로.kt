package boj.Dijkstra.특정한최단경로1504

import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, e) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }
    val (v1, v2) = readLine().split(" ").map { it.toInt() }

    val oneToV1 = getMinimumDistance(1, v1, n, graph)
    val v1ToV2 = getMinimumDistance(v1, v2, n, graph)
    val v2ToN = getMinimumDistance(v2, n, n, graph)
    val case1 = if (oneToV1 == -1 || v1ToV2 == -1 || v2ToN == -1) {
        Int.MAX_VALUE
    } else {
        oneToV1 + v1ToV2 + v2ToN
    }

    val oneToV2 = getMinimumDistance(1, v2, n ,graph)
    val v2ToV1 = getMinimumDistance(v2, v1, n, graph)
    val v1ToN = getMinimumDistance(v1, n, n, graph)
    val case2 = if (oneToV2 == -1 || v2ToV1 == -1 || v1ToN == -1) {
        Int.MAX_VALUE
    } else {
        oneToV2 + v2ToV1 + v1ToN
    }

    val answer = min(case1, case2)
    val result = if (answer == Int.MAX_VALUE) {
        -1
    } else {
        answer
    }
    println(result)
    close()
}

private fun getMinimumDistance(start: Int, end: Int, n: Int, graph: Array<MutableList<Pair<Int, Int>>>): Int {
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    dijkstra(start, distances, graph)
    val dist = distances[end]
    return if (distances[end] == Int.MAX_VALUE) {
        -1
    } else {
        dist
    }
}

private fun dijkstra(start: Int, distances: IntArray, graph: Array<MutableList<Pair<Int, Int>>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    distances[start] = 0

    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()

        if (distances[x] < dist) continue

        graph[x].forEach { (n, d) ->
            val newDist = dist + d

            if (distances[n] > newDist) {
                distances[n] = newDist
                q.add(n to newDist)
            }
        }
    }
}