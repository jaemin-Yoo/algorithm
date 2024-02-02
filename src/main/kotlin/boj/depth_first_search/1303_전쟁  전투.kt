package boj.depth_first_search

/**
 * 문제 번호: (1303)
 * 문제 이름: (전쟁 - 전투)
 * 소요 시간(분): (24)
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

private var cnt = 1

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<String>()
    repeat(m) {
        val row = readLine()
        graph.add(row)
    }
    val visited = Array(m) { BooleanArray(n) }
    var a = 0
    var b = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visited[i][j]) {
                cnt = 1
                visited[i][j] = true
                dfs(graph, visited, i to j, graph[i][j], m, n)
                if (graph[i][j] == 'W') {
                    a += cnt * cnt
                } else {
                    b += cnt * cnt
                }

            }
        }
    }
    println("$a $b")
    close()
}

private fun dfs(graph: MutableList<String>, visited: Array<BooleanArray>, pos: Pair<Int, Int>, c: Char, m: Int, n: Int) {
    for (i in 0 until 4) {
        val a = pos.first + dx[i]
        val b = pos.second + dy[i]
        if (a in 0 until m && b in 0 until n && graph[a][b] == c && !visited[a][b]) {
            cnt++
            visited[a][b] = true
            dfs(graph, visited, a to b, c, m, n)
        }
    }
}