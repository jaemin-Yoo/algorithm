package boj.depth_first_search

/**
 * 문제 번호: (1240)
 * 문제 이름: (노드사이의 거리)
 * 소요 시간(분): (15)
 */

private var answer = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map{ it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (a, b, d) = readLine().split(" ").map{ it.toInt() }
        graph[a].add(b to d)
        graph[b].add(a to d)
    }

    repeat(m) {
        val visited = BooleanArray(n + 1)
        val (a, b) = readLine().split(" ").map{ it.toInt() }
        visited[a] = true

        dfs(a, b, 0, visited, graph)
        println(answer)
    }
    close()
}

private fun dfs(x: Int, k: Int, dist: Int, visited: BooleanArray, graph: Array<MutableList<Pair<Int, Int>>>): Boolean {
    if (x == k) {
        answer = dist
        return true
    }

    graph[x].forEach { (a, d) ->
        if (!visited[a]) {
            visited[a] = true
            if (dfs(a, k, dist + d, visited, graph)) return true
            visited[a] = false
        }
    }

    return false
}