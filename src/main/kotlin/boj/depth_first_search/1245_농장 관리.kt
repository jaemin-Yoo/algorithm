package boj.depth_first_search

/**
 * 문제 번호: (1245)
 * 문제 이름: (농장 관리)
 * 소요 시간(분): (37)
 */

private val dx = listOf(1, 1, 1, 0, 0, -1, -1, -1)
private val dy = listOf(1, 0, -1, 1, -1, 1, 0, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    repeat(n) {
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[it] = row
    }

    var cnt = 0
    val visited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j]) {
                val isPeak = bfs(graph, visited, n, m, i to j)
                if (isPeak) cnt++
            }
        }
    }
    println(cnt)
}

private fun bfs(graph: Array<IntArray>, visited: Array<BooleanArray>, n: Int, m: Int, start: Pair<Int, Int>): Boolean {
    val dq = ArrayDeque<Pair<Int, Int>>()
    dq.add(start)

    var isPeak = true
    while (dq.isNotEmpty()) {
        val (x, y) = dq.removeFirst()
        for (k in 0 until 8) {
            val a = dx[k] + x
            val b = dy[k] + y
            if (a in 0 until n && b in 0 until m) {
                if (graph[a][b] == graph[x][y] && !visited[a][b]) {
                    visited[a][b] = true
                    dq.add(a to b)
                } else if (graph[a][b] > graph[x][y]) {
                    isPeak = false
                }
            }
        }
    }

    return isPeak
}