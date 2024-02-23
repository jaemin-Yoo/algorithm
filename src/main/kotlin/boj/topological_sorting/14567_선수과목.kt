package boj.topological_sorting

/**
 * 문제 번호: (14567)
 * 문제 이름: (선수과목)
 * 소요 시간(분): (14)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        inDegree[b]++
    }
    val result = topologicalSort(graph, inDegree, n)
    println(result.joinToString(" "))
    close()
}

private fun topologicalSort(graph: Array<MutableList<Int>>, inDegree: IntArray, n: Int): IntArray {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    val result = IntArray(n)
    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            q.add(i to 1)
            result[i - 1] = 1
        }
    }

    for (i in 1 until n + 1) {
        val (x, semester) = q.poll()
        graph[x].forEach { a ->
            if (--inDegree[a] == 0) {
                q.add(a to semester + 1)
                result[a - 1] = semester + 1
            }
        }
    }

    return result
}