package boj.depth_first_search

/**
 * 문제 번호: (1260)
 * 문제 이름: (DFS와 BFS)
 * 소요 시간(분): (25)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m, v) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    graph.forEach {
        it.sort()
    }
    println(dfs(graph, BooleanArray(n + 1), n, v, mutableListOf()))
    println(bfs(graph, n, v))
}

private fun dfs(graph: Array<MutableList<Int>>, visited: BooleanArray, n: Int, v: Int, result: MutableList<Int>): String {
    visited[v] = true
    result.add(v)

    graph[v].forEach { a ->
        if (!visited[a]) {
            dfs(graph, visited, n, a, result)
        }
    }
    return result.joinToString(" ")
}

private fun bfs(graph: Array<MutableList<Int>>, n: Int, v: Int): String {
    val visited = BooleanArray(n + 1)
    val q = ArrayDeque<Int>()
    visited[v] = true
    q.add(v)

    val result = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val x = q.removeFirst()
        result.add(x)

        graph[x].forEach { a ->
            if (!visited[a]) {
                visited[a] = true
                q.add(a)
            }
        }
    }
    return result.joinToString(" ")
}