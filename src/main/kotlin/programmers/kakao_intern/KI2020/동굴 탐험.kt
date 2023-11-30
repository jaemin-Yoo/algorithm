package programmers.KI2020.동굴탐험

import java.util.Queue
import java.util.LinkedList

class Solution {
    fun solution(n: Int, path: Array<IntArray>, order: Array<IntArray>): Boolean {
        val graph = Array(n) { mutableListOf<Int>() }
        val visited = BooleanArray(n)
        val preList = IntArray(n) { -1 }
        val postList = IntArray(n) { -1 }
        path.forEach { (a, b) ->
            graph[a].add(b)
            graph[b].add(a)
        }
        order.forEach { (a, b) ->
            postList[a] = b
            preList[b] = a
        }

        bfs(0, graph, visited, BooleanArray(n), preList, postList)
        return !visited.contains(false)
    }

    private fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: BooleanArray, waitList: BooleanArray, preList: IntArray, postList: IntArray) {
        val q: Queue<Int> = LinkedList()
        q.add(start)
        visited[start] = true

        if (preList[0] != -1) {
            return
        }

        while (q.isNotEmpty()) {
            val n = q.poll()
            graph[n].forEach { node ->
                val preNode = preList[node]
                if (!visited[node]) {
                    if (preNode == -1 || visited[preNode]) {
                        visited[node] = true
                        q.add(node)
                    } else {
                        waitList[node] = true
                    }
                }

                val postNode = postList[node]
                if (postNode != -1 && waitList[postNode]) {
                    visited[postNode] = true
                    waitList[postNode] = false
                    q.add(postNode)
                    preList[postNode] = -1
                    postList[node] = -1
                }
            }
        }
    }
}