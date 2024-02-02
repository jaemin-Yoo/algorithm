package boj.depth_first_search.깊이우선탐색2

/**
 * 문제 번호: (24480)
 * 문제 이름: (알고리즘 수업 - 깊이 우선 탐색 2)
 * 소요 시간(분): (5)
 */

var order = 1

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    graph.forEach {
        it.sortDescending()
    }
    val visited = IntArray(n + 1)
    visited[r] = order
    dfs(graph, visited, r, n)
    for (i in 1 until n + 1) {
        println(visited[i])
    }
}

private fun dfs(graph: Array<MutableList<Int>>, visited: IntArray, x: Int, n: Int) {
    graph[x].forEach { a ->
        if (visited[a] == 0) {
            visited[a] = ++order
            dfs(graph, visited, a, n)
        }
    }
}