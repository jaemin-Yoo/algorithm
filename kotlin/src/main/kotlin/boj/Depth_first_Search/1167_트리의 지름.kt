package boj.Depth_first_Search.트리의지름1167

private lateinit var graph: MutableList<MutableList<Pair<Int, Int>>>
private lateinit var visited: BooleanArray
private var result = 0
private var endNode = 0

fun main() = with(System.`in`.bufferedReader()) {
    val v = readLine().toInt()
    graph = MutableList(v + 1) { mutableListOf() }
    repeat(v) {
        val input = readLine().split(" ").map { it.toInt() }
        val idx = input[0]
        for (i in 1 until input.lastIndex step 2) {
            graph[idx].add(input[i] to input[i + 1])
        }
    }

    visited = BooleanArray(v + 1)
    dfs(1, 0)

    visited = BooleanArray(v + 1)
    dfs(endNode, 0)

    print(result)

    close()
}

fun dfs(start: Int, dist: Int) {
    if (result < dist) {
        result = dist
        endNode = start
    }

    visited[start] = true

    for ((node, d) in graph[start]) {
        if (!visited[node]) {
            dfs(node, dist + d)
        }
    }
}