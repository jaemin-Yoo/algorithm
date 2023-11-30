package programmers.KAKAOTECHINTERNSHIP2022

import java.util.Queue
import java.util.LinkedList
import kotlin.math.max

class Solution {
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
        paths.forEach { (a, b, w) ->
            graph[a].add(b to w)
            graph[b].add(a to w)
        }
        val distances = IntArray(n + 1) { Int.MAX_VALUE}
        gates.forEach { start ->
            dijkstra(start, distances, summits, graph)
        }

        val sortedList = summits.map { summit ->
            summit to distances[summit]
        }.sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
        val (dist, node) = sortedList[0]
        return intArrayOf(dist, node)
    }

    private fun dijkstra(start: Int, distances: IntArray, summits: IntArray, graph: Array<MutableList<Pair<Int, Int>>>) {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(start to 0)

        while (q.isNotEmpty()) {
            val (x, dist) = q.poll()

            if (x in summits || distances[x] < dist) continue

            graph[x].forEach { (n, d) ->
                val newDist = max(dist, d)
                if (distances[n] > newDist) {
                    distances[n] = newDist
                    q.add(n to newDist)
                }
            }
        }
    }
}