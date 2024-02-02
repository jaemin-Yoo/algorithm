package boj.breadth_first_search

/**
 * 문제 번호: (24444)
 * 문제 이름: (알고리즘 수업 - 너비 우선 탐색 1)
 * 소요 시간(분): (15)
 */

import java.util.Queue
import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    graph.forEach {
        it.sort()
    }
    val visited = bfs(graph, r, n)
    for(i in 1 until n + 1) {
        println(visited[i])
    }
    close()
}

private fun bfs(graph: Array<MutableList<Int>>, start: Int, n: Int): IntArray {
    val visited = IntArray(n + 1)
    val q: Queue<Int> = LinkedList()
    q.add(start)
    visited[start] = 1

    var order = 1
    while (q.isNotEmpty()) {
        val x = q.poll()
        graph[x].forEach { a ->
            if (visited[a] == 0) {
                visited[a] = ++order
                q.add(a)
            }
        }
    }
    return visited
}