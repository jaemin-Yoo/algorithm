package boj.Breadth_first_Search.이분그래프1707

import java.util.LinkedList
import java.util.Queue

fun main() {
    val k = readln().toInt()
    repeat(k) {
        val (v, e) = readln().split(" ").map { it.toInt() }
        val graph = List(v + 1) { mutableListOf<Int>() }
        val visited = MutableList(v + 1) { 0 }
        repeat(e) {
            val (a, b) = readln().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }

        for (i in 1 until v + 1) {
            val ans = bfs(i, graph, visited)
            if (!ans) {
                println("NO")
                return@repeat
            }
        }
        println("YES")
    }
}

fun bfs(start: Int, graph: List<MutableList<Int>>, visited: MutableList<Int>): Boolean {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 1)

    if (visited[start] != 0) {
        return true
    }
    visited[start] = 1

    while (q.isNotEmpty()) {
        val (a, group) = q.poll()

        for (next in graph[a]) {

            if (visited[next] == 0) {
                val newGroup = group * -1
                visited[next] = newGroup
                q.add(next to newGroup)
            } else if (visited[next] == group) {
                return false
            }
        }
    }

    return true
}