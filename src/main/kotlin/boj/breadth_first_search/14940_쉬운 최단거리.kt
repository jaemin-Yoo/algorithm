package boj.breadth_first_search

/**
 * 문제 번호: (14940)
 * 문제 이름: (쉬운 최단거리)
 * 소요 시간(분): (x)
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    repeat(n) { i ->
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[i] = row
    }

    val (x, y) = getStartPosition(graph, n, m)
    val result = bfs(graph, n, m, x, y)
    result.forEach {
        println(it.joinToString(" "))
    }
}

private fun getStartPosition(graph: Array<IntArray>, n: Int, m: Int): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 2) {
                return i to j
            }
        }
    }

    return -1 to -1
}

private fun bfs(graph: Array<IntArray>, n: Int, m: Int, sx: Int, sy: Int): Array<IntArray> {
    val visited = Array(n) { IntArray(m) { -1 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                visited[i][j] = 0
            }
        }
    }

    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(sx, sy))
    visited[sx][sy] = 0

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n && b in 0 until m && visited[a][b] == -1) {
                visited[a][b] = visited[x][y] + 1
                q.add(intArrayOf(a, b))
            }
        }
    }
    return visited
}