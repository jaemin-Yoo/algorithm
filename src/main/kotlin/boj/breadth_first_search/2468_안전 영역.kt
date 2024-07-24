package boj.breadth_first_search

/**
 * 문제 번호: (2468)
 * 문제 이름: (안전 영역)
 * 소요 시간(분): (27)
 */

import kotlin.math.max

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val graph = Array(n) { IntArray(n) }
    repeat(n) { i ->
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[i] = row
    }
    val maxHeight = getMaxHeight(graph, n)
    var result = 1
    for (k in 1 until maxHeight + 1) {
        val visited = Array(n) { BooleanArray(n) }
        var cnt = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j] && graph[i][j] > k) {
                    bfs(graph, visited, n, i, j, k)
                    cnt++
                }
            }
        }
        result = max(result, cnt)
    }
    print(result)
}

private fun getMaxHeight(graph: Array<IntArray>, n: Int): Int {
    var maxHeight = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            maxHeight = max(maxHeight, graph[i][j])
        }
    }
    return maxHeight
}

private fun bfs(graph: Array<IntArray>, visited: Array<BooleanArray>, n: Int, sx: Int, sy: Int, maxHeight: Int) {
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(sx to sy)
    visited[sx][sy] = true

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (i in 0 until 4) {
            val a = dx[i] + x
            val b = dy[i] + y
            if (a in 0 until n && b in 0 until n && !visited[a][b] && graph[a][b] > maxHeight) {
                visited[a][b] = true
                q.add(a to b)
            }
        }
    }
}