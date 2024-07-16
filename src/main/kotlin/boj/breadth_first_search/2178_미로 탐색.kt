package boj.breadth_first_search

/**
 * 문제 번호: (2178)
 * 문제 이름: (미로 탐색)
 * 소요 시간(분): (12)
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    repeat(n) { i ->
        val row = br.readLine().map { it.digitToInt() }.toIntArray()
        graph[i] = row
    }
    val result = bfs(graph, n, m)
    println(result)
}

private fun bfs(graph: Array<IntArray>, n: Int, m: Int): Int {
    val visited = Array(n) { IntArray(m) { -1 } }
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(0 to 0)
    visited[0][0] = 1

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n && b in 0 until m && graph[a][b] == 1 && visited[a][b] == -1) {
                visited[a][b] = visited[x][y] + 1
                q.add(a to b)
            }
        }
    }

    return visited[n - 1][m - 1]
}