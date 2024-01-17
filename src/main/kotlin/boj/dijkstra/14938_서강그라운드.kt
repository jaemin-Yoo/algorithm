package boj.dijkstra

/**
 * 문제 번호: [14938]
 * 문제 이름: [서강그라운드]
 * 소요 시간(분): [32]
 */

import java.util.Queue
import java.util.LinkedList
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }
    val items = readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
    repeat(r) {
        val (a, b, l) = readLine().split(" ").map { it.toInt() }
        graph[a - 1].add(b - 1 to l)
        graph[b - 1].add(a - 1 to l)
    }

    var result = 0
    for (i in 0 until n) {
        result = max(result, bfs(graph, items, i, n, m))
    }
    println(result)

    close()
}

private fun bfs(graph: Array<MutableList<Pair<Int, Int>>>, items: List<Int>, start: Int, n: Int, m: Int): Int {
    val distances = IntArray(n) { Int.MAX_VALUE }
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)
    distances[start] = 0

    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()
        graph[x].forEach { (a, l) ->
            val newDist = dist + l
            if (distances[a] > newDist && m >= newDist) {
                distances[a] = newDist
                q.add(a to newDist)
            }
        }
    }

    var cnt = 0
    for (i in 0 until n) {
        if (distances[i] < Int.MAX_VALUE) {
            cnt += items[i]
        }
    }

    return cnt
}