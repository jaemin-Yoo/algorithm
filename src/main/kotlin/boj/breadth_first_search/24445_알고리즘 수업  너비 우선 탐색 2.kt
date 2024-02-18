package boj.breadth_first_search

/**
 * 문제 번호: (24445)
 * 문제 이름: (알고리즘 수업 - 너비 우선 탐색 2)
 * 소요 시간(분): (7)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    for (i in 1 until n + 1) {
        graph[i].sortDescending()
    }

    val result = bfs(graph, n, r)
    for (i in 1 until n + 1) {
        println(result[i])
    }
    close()
}

private fun bfs(graph: Array<MutableList<Int>>, n: Int, r: Int): IntArray {
    val result = IntArray(n + 1)
    val visited = BooleanArray(n + 1)
    var order = 1
    val q: Queue<Int> = LinkedList()
    q.add(r)
    result[r] = order++
    visited[r] = true
    while (q.isNotEmpty()) {
        val x = q.poll()
        graph[x].forEach { a ->
            if (!visited[a]) {
                visited[a] = true
                q.add(a)
                result[a] = order++
            }
        }
    }

    return result
}