package boj.topological_sorting

/**
 * 문제 번호: (1516)
 * 문제 이름: (게임 개발)
 * 소요 시간(분): (45)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val distances = IntArray(n + 1) { Int.MAX_VALUE }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val distGraph = IntArray(n + 1)
    val priorityGraph = Array(n + 1) { mutableListOf<Int>() }
    val startNodes = mutableListOf<Int>()
    for (node in 1 until n + 1) {
        val input = readLine().split(" ").map { it.toInt() }
        val time = input[0]
        distGraph[node] = time

        if (input[1] == -1) {
            startNodes.add(node)
            continue
        }

        for (i in 1 until input.size - 1) {
            graph[input[i]].add(node)
            priorityGraph[node].add(input[i])
        }
    }

    for (node in startNodes) {
        dijkstra(graph, distances, distGraph, priorityGraph, node)
    }

    for (i in 1 until distances.size) {
        println(distances[i])
    }
    close()
}

private fun dijkstra(graph: Array<MutableList<Int>>, distances: IntArray, distGraph: IntArray, priorityGraph: Array<MutableList<Int>>, start: Int) {
    val q: Queue<Int> = LinkedList()
    val initDist = distGraph[start]
    distances[start] = initDist
    q.add(start)

    while (q.isNotEmpty()) {
        val x = q.poll()

        graph[x].forEach { a ->
            val dist = priorityGraph[a].map {
                distances[it]
            }.maxOf { it }
            if (dist == Int.MAX_VALUE) return@forEach

            val newDist = distGraph[a] + dist
            if (distances[a] > newDist) {
                distances[a] = newDist
                q.add(a)
            }
        }
    }
}