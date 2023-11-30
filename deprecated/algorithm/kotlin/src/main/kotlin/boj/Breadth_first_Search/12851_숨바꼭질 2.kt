package boj.Breadth_first_Search.숨바꼭질2_12851

import java.util.LinkedList
import java.util.Queue

private const val MAX_SIZE = 100001

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val visited = IntArray(MAX_SIZE) { 0 }

    val (time, cnt) = bfs(visited, n, k)
    println(time)
    println(cnt)

    close()
}

fun bfs(visited: IntArray, start: Int, end: Int): Pair<Int, Int> {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    visited[start] = 1

    var time = 0
    var cnt = 0
    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()
        if (x == end) {
            time = dist
            cnt += 1
        }
        addQueue(visited, q, x + 1, dist + 1)
        addQueue(visited, q, x - 1, dist + 1)
        addQueue(visited, q, x * 2, dist + 1)
    }
    return time to cnt
}

private fun addQueue(visited: IntArray, q: Queue<Pair<Int, Int>>, x: Int, dist: Int) {
    if (x in 0 until MAX_SIZE && (visited[x] >= dist || visited[x] == 0)) {
        visited[x] = dist
        q.add(x to dist)
    }
}