package boj.dynamic_programming

/**
 * 문제 번호: (1005)
 * 문제 이름: (ACM Craft)
 * 소요 시간(분): (21)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val (n, k) = readLine().split(" ").map { it.toInt() }
        val distance = IntArray(n + 1)
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val inDegree = IntArray(n + 1)
        val delayList = readLine().split(" ").map { it.toInt() }
        repeat(k) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            graph[x].add(y)
            inDegree[y]++
        }
        val target = readLine().toInt()
        dijkstra(graph, delayList, distance, inDegree, n)
        println(distance[target])
    }
    close()
}

private fun dijkstra(graph: Array<MutableList<Int>>, delayList: List<Int>, distance: IntArray, inDegree: IntArray, n: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            val dist = delayList[i - 1]
            distance[i] = dist
            q.add(i to dist)
        }
    }

    for (i in 0 until n) {
        val (x, dist) = q.poll()
        graph[x].forEach { a ->
            val newDist = dist + delayList[a - 1]
            if (distance[a] < newDist) {
                distance[a] = newDist
            }

            if (--inDegree[a] == 0) {
                q.add(a to distance[a])
            }
        }
    }
}