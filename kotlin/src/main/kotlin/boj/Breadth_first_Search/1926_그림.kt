package boj.Breadth_first_Search.그림

import java.lang.Integer.max
import java.util.LinkedList
import java.util.Queue

val graph = mutableListOf<MutableList<Int>>()
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
var n = 0
var m = 0
fun main() {
    val (_n, _m) = readln().split(" ").map { it.toInt() }
    n = _n
    m = _m
    repeat(n) {
        graph.add(readln().split(" ").map { it.toInt() }.toMutableList())
    }

    var pCnt = 0
    var maxCnt = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1) {
                maxCnt = max(maxCnt, bfs(i to j))
                pCnt += 1
            }
        }
    }
    println("$pCnt $maxCnt")
}

fun bfs(start: Pair<Int, Int>): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start)
    graph[start.first][start.second] = 0
    var cnt = 1
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n
                && b in 0 until m
                && graph[a][b] == 1) {
                graph[a][b] = 0
                q.add(a to b)
                cnt += 1
            }
        }
    }
    return cnt
}