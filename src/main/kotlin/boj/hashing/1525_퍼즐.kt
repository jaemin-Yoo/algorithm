package boj.hashing

/**
 * 문제 번호: (1525)
 * 문제 이름: (퍼즐)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

private val dx = listOf(
    listOf(1, 3),
    listOf(0, 2, 4),
    listOf(1, 5),
    listOf(0, 4, 6),
    listOf(1, 3, 5, 7),
    listOf(2, 4, 8),
    listOf(3, 7),
    listOf(4, 6, 8),
    listOf(5, 7)
)

fun main() = with(System.`in`.bufferedReader()) {
    val graph = mutableListOf<MutableList<Int>>()
    repeat(3) {
        val row = readLine().split(" ").map { it.toInt() }.toMutableList()
        graph.add(row)
    }
    val result = bfs(graph)
    println(result)

    close()
}

private fun bfs(graph: MutableList<MutableList<Int>>): Int {
    val visited = HashMap<String, Boolean>()
    val q: Queue<Pair<String, Int>> = LinkedList()
    val initStr = graphToString(graph)
    q.add(initStr to 0)
    visited[initStr] = true

    while (q.isNotEmpty()) {
        val (str, dist) = q.poll()
        if (str == "123456780") {
            return dist
        }

        val idx = str.indexOf('0')
        dx[idx].forEach { x ->
            val arr = str.toCharArray()
            val temp = arr[x]
            arr[x] = arr[idx]
            arr[idx] = temp

            val newStr = arr.joinToString("")
            if (!visited.containsKey(newStr)) {
                visited[newStr] = true
                q.add(newStr to dist + 1)
            }
        }
    }

    return -1
}

private fun graphToString(graph: MutableList<MutableList<Int>>) = graph.joinToString("") { it.joinToString("") }