package boj.depth_first_search

/**
 * 문제 번호: (1388)
 * 문제 이름: (바닥 장식)
 * 소요 시간(분): (14)
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n) { CharArray(m) }
    repeat(n) { i ->
        val row = br.readLine().toCharArray()
        graph[i] = row
    }

    val visited = Array(n) { BooleanArray(m) }
    var cnt = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j]) {
                dfs(graph, visited, i, j, n, m)
                cnt++
            }
        }
    }
    println(cnt)
}

private fun dfs(graph: Array<CharArray>, visited: Array<BooleanArray>, startX: Int, startY: Int, n: Int, m: Int) {
    val stack = ArrayDeque<Pair<Int, Int>>()
    visited[startX][startY] = true
    stack.add(startX to startY)

    while (stack.isNotEmpty()) {
        val (x, y) = stack.removeLast()
        for (i in 0 until 4) {
            var a = x
            var b = y
            if (graph[startX][startY] == '-') {
                b = y + dy[i]
            } else {
                a = x + dx[i]
            }

            if (a in 0 until n && b in 0 until m && graph[a][b] == graph[startX][startY] && !visited[a][b]) {
                visited[a][b] = true
                stack.add(a to b)
            }
        }
    }
}