package boj.depth_first_search

/**
 * 문제 번호: (13565)
 * 문제 이름: (침투)
 * 소요 시간(분): (15)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    val visited = Array(m) { BooleanArray(n) }
    repeat(m) {
        val row = readLine().map { it.digitToInt() }
        graph.add(row)
    }

    for (i in 0 until n) {
        if (graph[0][i] == 0) {
            bfs(graph, visited, 0 to i, m, n)
        }
    }

    var result = "NO"
    for (i in 0 until n) {
        if (visited[m - 1][i]) {
            result = "YES"
            break
        }
    }
    println(result)
    close()
}

private fun bfs(graph: MutableList<List<Int>>, visited: Array<BooleanArray>, startPosition: Pair<Int, Int>, m: Int, n: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(startPosition)
    visited[startPosition.first][startPosition.second] = true

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until m && b in 0 until n && graph[a][b] == 0 && !visited[a][b]) {
                visited[a][b] = true
                q.add(a to b)
            }
        }
    }
}