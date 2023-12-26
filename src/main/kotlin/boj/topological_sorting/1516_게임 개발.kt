package boj.topological_sorting

/**
 * 문제 번호: (1516)
 * 문제 이름: (게임 개발)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val distGraph = IntArray(n + 1)
    val inDegree = IntArray(n + 1)
    for (node in 1 until n + 1) {
        val input = readLine().split(" ").map { it.toInt() }
        val time = input[0]
        distGraph[node] = time

        if (input[1] == -1) continue

        for (i in 1 until input.size - 1) {
            inDegree[node]++
            graph[input[i]].add(node)
        }
    }

    val result = topologicalSort(graph, distGraph, inDegree, n)
    for (i in 1 until n + 1) {
        println(result[i])
    }

    close()
}

private fun topologicalSort(graph: Array<MutableList<Int>>, distGraph: IntArray, inDegree: IntArray, n: Int): IntArray {
    val q: Queue<Pair<Int, Int>> = LinkedList()

    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            q.add(i to distGraph[i])
        }
    }

    val result = distGraph.clone()
    for (i in 1 until n + 1) {
        val (x, dist) = q.poll()
        graph[x].forEach { a ->
            val newDist = dist + distGraph[a]
            if (result[a] < newDist) {
                result[a] = newDist
            }
            if (--inDegree[a] == 0) {
                q.add(a to result[a])
            }
        }
    }

    return result
}