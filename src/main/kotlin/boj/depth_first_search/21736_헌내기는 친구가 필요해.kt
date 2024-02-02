package boj.depth_first_search

/**
 * 문제 번호: (21736)
 * 문제 이름: (헌내기는 친구가 필요해)
 * 소요 시간(분): (10)
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

private var cnt = 0

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<String>()
    val visited = Array(n) { BooleanArray(m) }
    repeat(n) {
        val row = readLine()
        graph.add(row)
    }

    val start = getStartPosition(graph, n, m)
    visited[start.first][start.second] = true
    dfs(graph, visited, start, n, m)
    if (cnt == 0) {
        println("TT")
    } else {
        println(cnt)
    }
}

private fun dfs(graph: MutableList<String>, visited: Array<BooleanArray>, pos: Pair<Int, Int>, n: Int, m: Int) {
    val x = pos.first
    val y = pos.second
    for (i in 0 until 4) {
        val a = x + dx[i]
        val b = y + dy[i]
        if (a in 0 until n && b in 0 until m && graph[a][b] != 'X' && !visited[a][b]) {
            if (graph[a][b] == 'P') {
                cnt++
            }
            visited[a][b] = true
            dfs(graph, visited, a to b, n, m)
        }
    }
}

private fun getStartPosition(graph: MutableList<String>, n: Int, m: Int): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'I') {
                return i to j
            }
        }
    }
    throw Exception("Error")
}