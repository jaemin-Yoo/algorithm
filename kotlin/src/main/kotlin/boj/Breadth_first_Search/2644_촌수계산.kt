package boj.Breadth_first_Search

import java.util.LinkedList
import java.util.Queue

class 촌수계산2644() {
    lateinit var graph: Array<MutableList<Int>>
    lateinit var visited: Array<Int>
    fun main() {
        val n = readln().toInt()
        val (x, y) = readln().split(' ').map { it.toInt() }
        graph = Array(n+1) { mutableListOf() }
        visited = Array(n+1) { 0 }

        val m = readln().toInt()
        repeat(m) {
            val (a, b) = readln().split(' ').map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        println(BFS(x, y))
    }

    fun BFS(start: Int, end: Int): Int {
        val q: Queue<Pair<Int, Int>> = LinkedList()
        q.add(start to 0)
        visited[start] = 1

        while (q.isNotEmpty()) {
            val (node, cnt) = q.poll()
            for (i in graph[node]) {
                if (visited[i] == 0) {
                    visited[i] = 1
                    q.add(i to cnt + 1)
                    if (i == end) return cnt + 1
                }
            }
        }

        return -1
    }
}