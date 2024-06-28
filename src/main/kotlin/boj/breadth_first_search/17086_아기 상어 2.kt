package boj.breadth_first_search.아기상어2

/**
 * 문제 번호: (17086)
 * 문제 이름: (아기 상어 2)
 * 소요 시간(분): (24)
 */

import java.util.Queue
import java.util.LinkedList
import kotlin.math.max

data class Node(
    val pos: Position,
    val dist: Int
)

data class Position(
    val x: Int,
    val y: Int
)

private val dx = listOf(1, 1, 1, -1, -1, -1, 0, 0)
private val dy = listOf(1, 0, -1, 1, 0, -1, 1, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    val distances = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        graph[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) {
                bfs(graph, distances, Position(i, j), n, m)
            }
        }
    }

    var maxDist = 0
    distances.forEach { arr ->
        maxDist = max(maxDist, arr.maxOf{ it })
    }
    println(maxDist)
}

private fun bfs(graph: Array<IntArray>, distances: Array<IntArray>, start: Position, n: Int, m: Int) {
    val q: Queue<Node> = LinkedList()
    q.add(Node(start, 0))

    while (q.isNotEmpty()) {
        val (pos, dist) = q.poll()
        for (i in 0 until 8) {
            val a = pos.x + dx[i]
            val b = pos.y + dy[i]
            val newDist = dist + 1
            if (a in 0 until n && b in 0 until m && graph[a][b] == 0 && (distances[a][b] == 0 || distances[a][b] > newDist)) {
                distances[a][b] = newDist
                q.add(Node(Position(a, b), newDist))
            }
        }
    }
}