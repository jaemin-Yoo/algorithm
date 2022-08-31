package boj.Breadth_first_Search

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

class 인구이동16234 {
    lateinit var graph: MutableList<MutableList<Int>>
    lateinit var tempGraph: MutableList<MutableList<Int>>
    lateinit var visited: Array<Array<Int>>
    var n = 0
    var l = 0
    var r = 0
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    var ans = 0
    fun main() {
        val (_n, _l, _r) = readln().split(' ').map { it.toInt() }
        n = _n
        l = _l
        r = _r
        graph = mutableListOf()
        tempGraph = mutableListOf()
        repeat(n) {
            val row = readln().split(' ').map { it.toInt() }
            graph.add(row.toMutableList())
            tempGraph.add(row.toMutableList())
        }

        var state = true
        while (state) {
            visited = Array(n) { Array(n) { 0 } }
            state = false
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (BFS(i to j)) {
                        state = true
                    }
                }
            }
            if (state) ans += 1

            for (i in 0 until n) {
                for (j in 0 until n) {
                    graph[i][j] = tempGraph[i][j]
                }
            }
        }
        println(ans)
    }

    fun BFS(start: Pair<Int, Int>): Boolean {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(start)

        if (visited[start.first][start.second] == 0) {
            visited[start.first][start.second] = 1
        } else return false

        var cnt = 1
        var s = graph[start.first][start.second]
        val arr = mutableListOf<Pair<Int, Int>>()
        arr.add(start)
        while (q.isNotEmpty()) {
            val (x, y) = q.poll()
            for (i in 0 until 4) {
                val a = x + dx[i]
                val b = y + dy[i]
                if (a in 0 until n
                    && b in 0 until n
                    && visited[a][b] == 0
                    && abs(graph[x][y] - graph[a][b]) in l .. r) {
                    visited[a][b] = 1
                    q.add(a to b)
                    cnt += 1
                    s += graph[a][b]
                    arr.add(a to b)
                }
            }
        }

        if (arr.size > 1) {
            val result = s / cnt
            for ((x, y) in arr) {
                tempGraph[x][y] = result
            }

            return true
        }

        return false
    }
}