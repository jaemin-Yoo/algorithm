package boj.breadth_first_search.데스나이트16948

/**
 * 문제 번호: (16948)
 * 문제 이름: (데스 나이트)
 * 소요 시간(분): (12)
 */

import java.util.PriorityQueue

private val dx = listOf(-2, -2, 0, 0, 2, 2)
private val dy = listOf(-1, 1, -2, 2, -1, 1)

data class Node(
    val x: Int,
    val y: Int,
    val cnt: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val distances = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val (r1, c1, r2, c2) = readLine().split(" ").map { it.toInt() }
    dijkstra(distances, r1 to c1, r2 to c2, n)
    val result = if (distances[r2][c2] == Int.MAX_VALUE) {
        -1
    } else {
        distances[r2][c2]
    }
    println(result)
    close()
}

private fun dijkstra(distances: Array<IntArray>, start: Pair<Int, Int>, end: Pair<Int, Int>, n: Int) {
    val pq = PriorityQueue<Node> { a, b ->
        a.cnt - b.cnt
    }
    pq.add(Node(start.first, start.second, 0))

    while (pq.isNotEmpty()) {
        val (x, y, cnt) = pq.poll()
        if (distances[x][y] < cnt || x to y == end) continue

        for (i in 0 until 6) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n && b in 0 until n) {
                val newCnt = cnt + 1
                if (distances[a][b] > newCnt) {
                    distances[a][b] = newCnt
                    pq.add(Node(a, b, newCnt))
                }
            }
        }
    }
}