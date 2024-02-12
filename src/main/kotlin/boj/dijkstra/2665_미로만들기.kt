package boj.dijkstra

/**
 * 문제 번호: (2665)
 * 문제 이름: (미로만들기)
 * 소요 시간(분): (17)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

data class Node(
    val x: Int,
    val y: Int,
    val changeCount: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = mutableListOf<List<Int>>()
    val distances = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    repeat(n) {
        val row = readLine().map { it.digitToInt() }
        graph.add(row)
    }
    dijkstra(graph, distances, n)
    println(distances[n - 1][n - 1])

    close()
}

private fun dijkstra(graph: MutableList<List<Int>>, distances: Array<IntArray>, n: Int) {
    val q: Queue<Node> = LinkedList()
    q.add(Node(0, 0, 0))
    distances[0][0] = 0

    while (q.isNotEmpty()) {
        val (x, y, cnt) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n && b in 0 until n) {
                val newCnt = if (graph[a][b] == 0) {
                    cnt + 1
                } else {
                    cnt
                }

                if (distances[a][b] > newCnt) {
                    distances[a][b] = newCnt
                    q.add(Node(a, b, newCnt))
                }
            }
        }
    }
}