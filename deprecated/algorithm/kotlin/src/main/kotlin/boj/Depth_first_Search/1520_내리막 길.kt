package boj.Depth_first_Search.내리막길1520

private val graph = mutableListOf<MutableList<Int>>()
private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    repeat(n) {
        val row = readln().split(" ").map { it.toInt() }.toMutableList()
        graph.add(row)
    }
    val visited = MutableList(n) { MutableList(m) { -1 } }
    println(dfs(0, 0, graph[0][0], visited))
}

fun dfs(x: Int, y: Int, num: Int, visited: MutableList<MutableList<Int>>): Int {
    if (x == graph.lastIndex && y == graph[0].lastIndex) {
        return 1
    }

    if (visited[x][y] != -1) {
        return visited[x][y]
    }

    visited[x][y] = 0
    for (i in 0 until 4) {
        val a = x + dx[i]
        val b = y + dy[i]
        if (a in graph.indices && b in graph[0].indices && graph[a][b] < num) {
            visited[x][y] += dfs(a, b, graph[a][b], visited)
        }
    }

    return visited[x][y]
}