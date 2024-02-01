package boj.breadth_first_search

/**
 * 문제 번호: (18352)
 * 문제 이름: (특정 거리의 도시 찾기)
 * 소요 시간(분): (13)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k, x) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
    }

    val result = bfs(graph, x, k, n)
    if (result.isEmpty()) {
        println(-1)
    } else {
        result.sorted().forEach {
            println(it)
        }
    }

    close()
}

private fun bfs(graph: Array<MutableList<Int>>, start: Int, k: Int, n: Int): List<Int> {
    val visited = BooleanArray(n + 1)
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    visited[start] = true

    val nodes = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()
        if (dist == k) {
            nodes.add(x)
            continue
        }

        graph[x].forEach { a ->
            val newDist = dist + 1
            if (!visited[a]) {
                visited[a] = true
                q.add(a to newDist)
            }
        }
    }

    return nodes
}