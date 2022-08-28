package boj.Breadth_first_Search

import java.util.LinkedList
import java.util.Queue

var n = 0
var m = 0
val graph = mutableListOf<List<Char>>()
val visited by lazy { Array(n) { Array(m) { 0 } } }
var cnt = 0
fun main() {
    val (_n, _m) = readln().split(' ').map { it.toInt() }
    n = _n
    m = _m
    repeat(n) {
        graph.add(readln().toList())
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            bfs(i to j)
        }
    }

    println(cnt)
}

fun bfs(start: Pair<Int, Int>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start)

    if (visited[start.first][start.second] == 0) {
        visited[start.first][start.second] = 1
        cnt += 1
    } else return

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        var a = x
        var b = y
        if (graph[x][y] == '-') b += 1 else a += 1

        if (a in 0 until n
            && b in 0 until m
            && visited[a][b] == 0
            && graph[start.first][start.second] == graph[a][b]) {
            visited[a][b] = 1
            q.add(a to b)
        }
    }
}