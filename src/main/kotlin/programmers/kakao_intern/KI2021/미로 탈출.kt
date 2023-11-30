package programmers.KI2021.미로탈출

import java.util.Queue
import java.util.LinkedList

class Solution {

    fun solution(n: Int, start: Int, end: Int, roads: Array<IntArray>, traps: IntArray): Int {
        val graph = Array(n + 1) { mutableListOf<ConnectedNode>() }
        val visited = Array(n + 1) { BooleanArray(1024) }
        val distances = Array(n + 1) { IntArray(1024) { Int.MAX_VALUE } }
        val bitMap = mappingTrapBit(n + 1, traps)
        roads.forEach { (s, e, d) ->
            graph[s].add(ConnectedNode(e, d, false))
            graph[e].add(ConnectedNode(s, d, true))
        }

        dijkstra(start, distances, bitMap, visited, graph)
        return distances[end].minOf { it }
    }

    private fun dijkstra(start: Int, distances: Array<IntArray>, bitMap: IntArray, visited: Array<BooleanArray>, graph: Array<MutableList<ConnectedNode>>) {
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.add(Triple(start, 0, 0))

        while (q.isNotEmpty()) {
            val (x, dist, bit) = q.poll()

            graph[x].forEach { (n, d, b) ->
                val newDist = dist + d
                if ((distances[n][bit] > newDist) && (((bitMap[x] and bit) > 0) xor ((bitMap[n] and bit) > 0)) == b) {
                    distances[n][bit] = newDist

                    val newBit = bit xor bitMap[n]
                    q.add(Triple(n, newDist, newBit))
                }
            }
        }
    }

    private fun mappingTrapBit(n: Int, traps: IntArray): IntArray {
        val bitMap = IntArray(n)
        var i = 1
        traps.forEach {
            bitMap[it] = i
            i = i shl 1
        }
        return bitMap
    }

    data class ConnectedNode(
        val room: Int,
        val dist: Int,
        val isTrapRoad: Boolean
    )
}