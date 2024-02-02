package boj.breadth_first_search

/**
 * 문제 번호: (11060)
 * 문제 이름: (점프 점프)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val a = readLine().split(" ").map { it.toInt() }.toIntArray()
    val result = bfs(a, n)
    println(result)
}

private fun bfs(a: IntArray, n: Int): Int {
    val visited = BooleanArray(n)
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(0 to 0)
    visited[0] = true

    while (q.isNotEmpty()) {
        val (idx, dist) = q.poll()
        if (idx == n - 1) {
            return dist
        }
        for (i in 1..a[idx]) {
            if (idx + i >= n || visited[idx + i]) continue

            visited[idx + i] = true
            q.add(idx + i to dist + 1)
        }
    }
    return -1
}