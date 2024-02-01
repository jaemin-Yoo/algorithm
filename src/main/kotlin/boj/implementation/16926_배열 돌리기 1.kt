package boj.implementation

/**
 * 문제 번호: (16926)
 * 문제 이름: (배열 돌리기 1)
 * 소요 시간(분): (x)
 */

import kotlin.math.min

private val dx = listOf(0, 1, 0, -1)
private val dy = listOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }
        graph.add(row)
    }

    val newGraph = Array(n) { IntArray(m) }
    val cnt = min(n, m) / 2
    for (k in 0 until cnt) {
        var outerD = 0
        var (i, j) = k to k
        repeat(2 * n + 2 * (m - 2)) {
            var (x, y) = i to j
            var innerD = outerD
            repeat(r) {
                x += dx[innerD % 4]
                y += dy[innerD % 4]

                if ((x == k && y == m - k - 1) || (x == n - k - 1 && y == m - k - 1) || (x == n - k - 1 && y == k) || (x == k && y == k)) {
                    innerD++
                }
            }
            newGraph[i][j] = graph[x][y]

            i += dx[outerD % 4]
            j += dy[outerD % 4]

            if ((i == k && j == m - k - 1) || (i == n - k - 1 && j == m - k - 1) || (i == n - k - 1 && j == k) || (i == k && j == k)) {
                outerD++
            }
        }
    }
    newGraph.forEach { row ->
        println(row.joinToString(" "))
    }
    close()
}