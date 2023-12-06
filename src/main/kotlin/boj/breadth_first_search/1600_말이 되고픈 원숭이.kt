package boj.breadth_first_search

/**
 * 문제 번호: (1600)
 * 문제 이름: (말이 되고픈 원숭이)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(-1, 1, 0, 0, -2, -2, -1, -1, 1, 1, 2, 2)
private val dy = listOf(0, 0, -1, 1, 1, -1, -2, 2, -2, 2, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val (w, h) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<IntArray>()
    val distances = Array(h) { Array(w) { Int.MAX_VALUE to 0 } }
    repeat(h) {
        val row = readLine().split(" ").map { it.toInt() }.toIntArray()
        graph.add(row)
    }
    close()

    dijkstra(h, w, k, distances, graph)
    val result = distances[h - 1][w - 1].first
    val answer = if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
    println(answer)
}

private fun dijkstra(n: Int, m: Int, k: Int, distances: Array<Array<Pair<Int, Int>>>, graph: MutableList<IntArray>) {
    val q: Queue<Node> = LinkedList()
    q.add(Node(0, 0, 0, 0))
    distances[0][0] = 0 to 0

    while (q.isNotEmpty()) {
        val (x, y, cnt, dist) = q.poll()

        for (i in 0 until 12) {
            if (i >= 4 && cnt == k) break

            val a = x + dx[i]
            val b = y + dy[i]
            val count = if (i >= 4) {
                cnt + 1
            } else {
                cnt
            }

            if (a in 0 until n && b in 0 until m && graph[a][b] == 0) {
                val (d, c) = distances[a][b]
                if (d > dist + 1 || (d <= dist + 1 && count < c)) {
                    distances[a][b] = dist + 1 to count
                    if (a == n - 1 && b == m - 1) return

                    q.add(Node(a, b, count, dist + 1))
                }
            }
        }
    }
}

data class Node(
    val x: Int,
    val y: Int,
    val cnt: Int,
    val dist: Int
)