package boj.breadth_first_search.쉬운_최단거리14940

/**
 * 문제 번호: (14940)
 * 문제 이름: (쉬운 최단거리)
 * 소요 시간(분): (15)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

data class Position(
    val x: Int,
    val y: Int
)

data class Node(
    val pos: Position,
    val dist: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }
        graph.add(row)
    }
    val start = getStartPosition(graph, n, m)
    val newGraph = bfs(graph, start, n, m)
    newGraph.forEach {
        println(it.joinToString(" "))
    }
    close()
}

private fun bfs(graph: MutableList<List<Int>>, start: Position, n: Int, m: Int): Array<IntArray> {
    val q: Queue<Node> = LinkedList()
    q.add(Node(start, 0))

    val newGraph = Array(n) { IntArray(m) { -1 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                newGraph[i][j] = 0
            }
        }
    }

    newGraph[start.x][start.y] = 0
    while (q.isNotEmpty()) {
        val (pos, dist) = q.poll()
        val (x, y) = pos
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n && b in 0 until m && newGraph[a][b] == -1 && graph[a][b] == 1) {
                val newDist = dist + 1
                newGraph[a][b] = newDist
                q.add(Node(Position(a, b), newDist))
            }
        }
    }

    return newGraph
}

private fun getStartPosition(graph: MutableList<List<Int>>, n: Int, m: Int): Position {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 2) {
                return Position(i, j)
            }
        }
    }

    throw Exception()
}