package boj.Breadth_first_Search.빙산2573

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = mutableListOf<MutableList<Int>>()
    val dx = listOf(1, -1, 0, 0)
    val dy = listOf(0, 0, 1, -1)
    repeat(n) {
        val row = readln().split(" ").map { it.toInt() }.toMutableList()
        graph.add(row)
    }

    var years = 0
    var newGraph = graph
    while (true) {
        if (isSeparated(dx, dy, newGraph)) {
            println(years)
            break
        } else if (isZero(newGraph)) {
            println(0)
            break
        }

        newGraph = passOneYear(dx, dy, newGraph)
        years += 1
    }
}

fun isSeparated(dx: List<Int>, dy: List<Int>, graph: MutableList<MutableList<Int>>): Boolean {
    var end = false
    val visited = MutableList(graph.size) { MutableList(graph[0].size) { false } }
    for (i in 1 until graph.size - 1) {
        for (j in 1 until graph[0].size - 1) {
            if (graph[i][j] > 0 && !visited[i][j]) {
                if (end) {
                    return true
                }
                bfs(i, j, dx, dy, graph, visited)
                end = true
            }
        }
    }

    return false
}

fun isZero(graph: MutableList<MutableList<Int>>): Boolean {
    var s = 0
    graph.map { s += it.sum() }
    return s == 0
}


fun passOneYear(dx: List<Int>, dy: List<Int>, graph: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val newGraph = graph.map { it.toMutableList() }.toMutableList()
    for (i in 0 until graph.size) {
        for (j in 0 until graph[0].size) {
            if (graph[i][j] > 0) {
                for (k in 0 until 4) {
                    val a = i + dx[k]
                    val b = j + dy[k]
                    if (graph[a][b] == 0) {
                        newGraph[i][j] -= 1
                        if (newGraph[i][j] == 0) break
                    }
                }
            }
        }
    }

    return newGraph
}

fun bfs(startX: Int, startY: Int, dx: List<Int>, dy: List<Int>, graph: MutableList<MutableList<Int>>, visited: MutableList<MutableList<Boolean>>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(startX to startY)

    if (visited[startX][startY]) {
        return
    }
    visited[startX][startY] = true

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]

            if (a in graph.indices && b in graph[0].indices && !visited[a][b] && graph[a][b] > 0) {
                visited[a][b] = true
                q.add(a to b)
            }
        }
    }
}