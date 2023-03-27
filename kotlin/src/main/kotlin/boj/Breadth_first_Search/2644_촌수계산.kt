package boj.Breadth_first_Search.촌수계산2644

import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val (x, y) = readln().split(' ').map { it.toInt() }
    val m = readln().toInt()

    // 그래프 만들기
    val graph = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (parent, child) = readln().split(' ').map { it.toInt() }
        graph[parent].add(child)
        graph[child].add(parent)
    }

    // 방문 그래프 만들기
    val visited = BooleanArray(n + 1)

    val dist = dfs(x, y, graph, visited)
    println(dist)
}

fun dfs(start: Int, end: Int, graph: List<MutableList<Int>>, visited: BooleanArray): Int {
    // 첫 노드 큐 셋팅
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)

    // 첫 방문 노드 셋팅
    visited[start] = true

    while (q.isNotEmpty()) {
        val (n, dist) = q.poll()

        if (n == end) {
            return dist
        }

        for (next in graph[n]) {
            if (!visited[next]) {
                visited[next] = true
                q.add(next to dist + 1)
            }
        }
    }

    return -1
}