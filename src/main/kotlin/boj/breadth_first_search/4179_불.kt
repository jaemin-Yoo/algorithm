package boj.breadth_first_search.불4179

/**
 * 문제 번호: (4179)
 * 문제 이름: (불!)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

data class Position(
    val x: Int,
    val y: Int,
    val dist: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<CharArray>()
    repeat(r) {
        val row = readLine().toCharArray()
        graph.add(row)
    }

    println(bfs(graph, r, c))
    close()
}

private fun bfs(graph: MutableList<CharArray>, n: Int, m: Int): String {
    val fireQ: Queue<Position> = LinkedList()
    val fireVisited = Array(n) { IntArray(m) { -1 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'F') {
                fireQ.add(Position(i, j, 0))
                fireVisited[i][j] = 0
            }
        }
    }

    while (fireQ.isNotEmpty()) {
        val (x, y, dist) = fireQ.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n && b in 0 until m && graph[a][b] != '#' && fireVisited[a][b] == -1) {
                val newDist = dist + 1
                fireVisited[a][b] = newDist
                fireQ.add(Position(a, b, newDist))
            }
        }
    }

    val jQ: Queue<Position> = LinkedList()
    val jVisited = Array(n) { IntArray(m) { -1 } }
    val (jX, jY) = getStartPosition(graph, n, m)
    jQ.add(Position(jX, jY, 0))
    while (jQ.isNotEmpty()) {
        val (x, y, dist) = jQ.poll()
        val newDist = dist + 1
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a !in 0 until n || b !in 0 until m) {
                return newDist.toString()
            }

            if (graph[a][b] == '.' && (fireVisited[a][b] > newDist || fireVisited[a][b] == -1) && jVisited[a][b] == -1) {
                jVisited[a][b] = newDist
                jQ.add(Position(a, b, newDist))
            }
        }
    }

    return "IMPOSSIBLE"
}

private fun getStartPosition(graph: MutableList<CharArray>, n: Int, m: Int): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'J') {
                return i to j
            }
        }
    }

    throw Exception("No start position")
}