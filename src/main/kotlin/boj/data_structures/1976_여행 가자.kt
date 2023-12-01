package boj.data_structures

/**
 * 문제 번호: (1976)
 * 문제 이름: (여행 가자)
 * 소요 시간(분): (25)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }
        graph.add(row)
    }
    val path = readLine().split(" ").map { it.toInt() }

    val pathGraph = mutableListOf<BooleanArray>()
    for (i in 1 until n + 1) {
        val row = bfs(i, graph)
        pathGraph.add(row)
    }

    var answer = "YES"
    for (i in 0 until path.size - 1) {
        val x = path[i]
        val next = path[i + 1]
        if (!pathGraph[x - 1][next]) {
            answer = "NO"
            break
        }
    }
    println(answer)
    close()
}

fun bfs(start: Int, graph: MutableList<List<Int>>): BooleanArray {
    val q: Queue<Int> = LinkedList()
    q.add(start)

    val visited = BooleanArray(graph.size + 1)
    visited[start] = true

    while (q.isNotEmpty()) {
        val x = q.poll()
        for (i in graph[x - 1].indices) {
            if (graph[x - 1][i] == 1 && !visited[i + 1]) {
                q.add(i + 1)
                visited[i + 1] = true
            }
        }
    }

    return visited
}