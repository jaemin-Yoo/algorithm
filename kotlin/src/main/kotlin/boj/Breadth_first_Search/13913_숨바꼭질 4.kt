package boj.Breadth_first_Search.숨바꼭질13913

import java.util.*

private const val MAX_SIZE = 100001

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = MutableList(MAX_SIZE) { -1 }
    val result = bfs(n, k, visited).reversed()
    println(result.size - 1)
    println(result.joinToString(" "))
}

fun bfs(start: Int, end: Int, visited: MutableList<Int>): MutableList<Int> {
    val q: Queue<Int> = LinkedList()
    q.add(start)

    visited[start] = start
    while (q.isNotEmpty()) {
        val x = q.poll()
        if (x == end) {
            val result = mutableListOf<Int>()
            var prev = x
            result.add(prev)
            while (prev != start) {
                prev = visited[prev]
                result.add(prev)
            }
            return result
        }

        insert(x + 1, x, q, visited)
        insert(x - 1, x, q, visited)
        insert(2 * x, x, q, visited)
    }

    return mutableListOf()
}

fun insert(a: Int, x: Int, q: Queue<Int>, visited: MutableList<Int>) {
    if (a in 0 until MAX_SIZE && visited[a] == -1) {
        visited[a] = x
        q.add(a)
    }
}