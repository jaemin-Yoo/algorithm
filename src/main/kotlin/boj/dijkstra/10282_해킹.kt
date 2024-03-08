package boj.dijkstra

/**
 * 문제 번호: (10282)
 * 문제 이름: (해킹)
 * 소요 시간(분): (14)
 */

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val (n, d, c) = readLine().split(" ").map { it.toInt() }
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        val distances = IntArray(n + 1) { Int.MAX_VALUE }
        repeat(d) {
            val (a, b, s) = readLine().split(" ").map { it.toInt() }
            graph[b].add(a to s)
        }

        dijkstra(graph, distances, c)
        val filterDistances = distances.filter { it != Int.MAX_VALUE }
        val cnt = filterDistances.size
        val sec = filterDistances.maxOf { it }
        println("$cnt $sec")
    }
    close()
}

private fun dijkstra(graph: Array<MutableList<Pair<Int, Int>>>, distances: IntArray, c: Int) {
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        a.first - b.first
    }
    pq.add(c to 0)
    distances[c] = 0

    while (pq.isNotEmpty()) {
        val (x, s) =  pq.poll()
        if (distances[x] < s) continue

        graph[x].forEach { (a, sec) ->
            val newSec = sec + s
            if (distances[a] > newSec) {
                distances[a] = newSec
                pq.add(a to newSec)
            }
        }
    }
}