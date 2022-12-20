package boj.Breadth_first_Search

import java.util.Queue
import java.util.LinkedList
import kotlin.math.min

var n = 0
val graph = mutableListOf<IntArray>()
lateinit var visited1: Array<Array<Boolean>>
lateinit var visited2: Array<Array<Int>>
val dx = listOf(1, -1, 0, 0)
val dy = listOf(0, 0, 1, -1)
var mn = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    visited1 = Array(n) { Array(n) { false } }
    visited2 = Array(n) { Array(n) { 0 } }
    repeat(n) {
        graph.add(readLine().split(" ").map{ it.toInt() }.toIntArray())
    }

    var flag = 2
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 1) {
                graph[i][j] = flag
                bfs1(i to j, flag)
                flag += 1
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] != 0) {
                bfs2(i to j, graph[i][j])
            }
        }
    }
    println(mn)

    close()
}

// 섬 구분
fun bfs1(start: Pair<Int, Int>, flag: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start)
    visited1[start.first][start.second] = true
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n
                && b in 0 until n
                && !visited1[a][b]
                && graph[a][b] == 1) {
                q.add(a to b)
                visited1[a][b] = true
                graph[a][b] = flag
            }
        }
    }
}

// 최단 거리
fun bfs2(start: Pair<Int, Int>, flag: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start)
    visited2[start.first][start.second] = 1
    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n
                && b in 0 until n
                && visited2[a][b] == 0
                && visited2[a][b] <= visited2[x][y] + 1) {
                if (graph[a][b] == flag) {
                    q.add(a to b)
                    visited2[a][b] = 1
                } else if (graph[a][b] == 0) {
                    q.add(a to b)
                    visited2[a][b] = visited2[x][y] + 1
                } else if (graph[a][b] != flag) {
                    mn = min(mn, visited2[x][y] - 1)
                }
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            visited2[i][j] = 0
        }
    }
}