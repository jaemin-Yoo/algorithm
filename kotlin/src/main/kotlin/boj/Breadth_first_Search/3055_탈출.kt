package boj.Breadth_first_Search.탈출3055

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<MutableList<Char>>()

    repeat(r) {
        val row = readln().toMutableList()
        graph.add(row)
    }

    val visited = MutableList(r) { MutableList(c) { false } }

    run {
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (graph[i][j] == 'S') {
                    val count = bfs(i, j, graph, visited)
                    println(count)
                    return@run
                }
            }
        }
    }
}

fun bfs(startX: Int, startY: Int, graph: MutableList<MutableList<Char>>, visited: MutableList<MutableList<Boolean>>): String {
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    q.add(Triple(startX, startY, 0))

    visited[startX][startY] = true

    var d = 0
    while (q.isNotEmpty()) {
        val (x, y, dist) = q.poll()

        if (dist == d) {
            d += 1
            spreadWater(graph)
        }

        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]

            if (a in graph.indices && b in graph[0].indices && graph[a][b] == 'D') {
                return (dist + 1).toString()
            }

            if (a in graph.indices && b in graph[0].indices && graph[a][b] == '.' && !visited[a][b]) {
                visited[a][b] = true
                q.add(Triple(a, b, dist + 1))
            }
        }
    }

    return "KAKTUS"
}

fun spreadWater(graph: MutableList<MutableList<Char>>) {
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    val newGraph = graph.map { it.toMutableList() }.toMutableList()

    for (i in 0 until graph.size) {
        for (j in 0 until graph[0].size) {
            if (newGraph[i][j] == '*') {

                for (k in 0 until 4) {
                    val a = i + dx[k]
                    val b = j + dy[k]
                    if (a in graph.indices && b in graph[0].indices && newGraph[a][b] == '.') {
                        graph[a][b] = '*'
                    }
                }
            }
        }
    }
}