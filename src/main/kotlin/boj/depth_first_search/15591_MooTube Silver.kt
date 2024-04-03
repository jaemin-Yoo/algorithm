package boj.depth_first_search

/**
 * 문제 번호: (15591)
 * 문제 이름: (MooTube (Silver))
 * 소요 시간(분): (35)
 */

import kotlin.math.min

private data class Node(val node: Int, val dist: Int)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, qq) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Node>() }
    repeat(n - 1) {
        val (p, q, r) = br.readLine().split(' ').map { it.toInt() }
        graph[p].add(Node(q, r))
        graph[q].add(Node(p, r))
    }
    repeat(qq) {
        val (k, v) = br.readLine().split(' ').map { it.toInt() }
        val distances = IntArray(n + 1) { -1 }
        bfs(graph, distances, v)
        println(distances.count { k <= it } - 1)
    }
}

private fun bfs(graph: Array<MutableList<Node>>, distances: IntArray, start: Int) {
    val deque = ArrayDeque<Node>()
    deque.add(Node(start, Int.MAX_VALUE))
    while (deque.isNotEmpty()) {
        val (node, dist) = deque.removeFirst()
        distances[node] = dist

        graph[node].forEach { (nextNode, nextDist) ->
            if (distances[nextNode] == -1) {
                val newDist = min(dist, nextDist)
                deque.addLast(Node(nextNode, newDist))
            }
        }
    }
}