package boj.breadth_first_search

/**
 * 문제 번호: (6118)
 * 문제 이름: (숨바꼭질)
 * 소요 시간(분): (12)
 */

import java.util.ArrayDeque

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val result = bfs(graph, n)
    println(result.joinToString(" "))
}

private fun bfs(graph: Array<MutableList<Int>>, n: Int): IntArray {
    val visited = BooleanArray(n + 1)
    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(1 to 0)
    visited[1] = true
    var maxDist = 0
    val result = mutableListOf<Int>()
    while (deque.isNotEmpty()) {
        val (node, dist) = deque.poll()
        if (maxDist == dist) {
            result.add(node)
        }

        graph[node].forEach { a ->
            if (!visited[a]) {
                visited[a] = true
                deque.add(a to dist + 1)
                if (maxDist < dist + 1) {
                    maxDist = dist + 1
                    result.clear()
                }
            }
        }
    }
    val minNode = result.minOf { it }
    val cnt = result.size
    return intArrayOf(minNode, maxDist, cnt)
}