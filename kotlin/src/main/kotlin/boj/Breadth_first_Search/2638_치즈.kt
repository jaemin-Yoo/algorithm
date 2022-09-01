package boj.Breadth_first_Search

import java.util.Queue
import java.util.LinkedList

class 치즈2638 {
    val graph = mutableListOf<MutableList<Int>>()
    lateinit var visited: Array<Array<Int>>
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    var n = 0
    var m = 0
    fun main() {
        val (_n, _m) = readln().split(' ').map { it.toInt() }
        n = _n
        m = _m
        repeat(n) {
            graph.add(readln().split(' ').map { it.toInt() }.toMutableList())
        }

        for (i in 0 until n) {
            for (j in 0 until m) {

            }
        }

        var result = 0
        while (true) {
            val s = graph.sumOf { it.sum() }
            if (s == 0) break

            visited = Array(n) { Array(m) { 0 } }
            BFS(0 to 0)
            result += 1

            for (i in 0 until n) {
                for (j in 0 until m) {
                    if (graph[i][j] != 0) graph[i][j] = 1
                }
            }
        }
        println(result)
    }

    fun BFS(start: Pair<Int, Int>) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(start)
        visited[start.first][start.second] = 1
        while (q.isNotEmpty()) {
            val (x, y) = q.poll()
            for (i in 0 until 4) {
                val a = x + dx[i]
                val b = y + dy[i]
                if (a in 0 until n
                    && b in 0 until m
                    && visited[a][b] == 0) {
                    if (graph[a][b] == 0) {
                        visited[a][b] = 1
                        q.add(a to b)
                    } else {
                        graph[a][b] += 1
                        if (graph[a][b] == 3) {
                            graph[a][b] = 0
                            visited[a][b] = 1
                        }
                    }
                }
            }
        }
    }
}