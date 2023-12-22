package boj.topological_sorting

/**
 * 문제 번호: (2252)
 * 문제 이름: (줄 세우기)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map{ it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map{ it.toInt() }
        graph[a].add(b)
        inDegree[b]++
    }

    val result = topologySort(graph, inDegree, n)
    println(result.joinToString(" "))
    close()
}

private fun topologySort(graph: Array<MutableList<Int>>, inDegree: IntArray, n: Int): IntArray {
    val q: Queue<Int> = LinkedList()

    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    val result = IntArray(n)
    for (i in 1 until n + 1) {
        if (q.isEmpty()) {
            throw Exception("사이클 발생")
        }

        val x = q.poll()
        result[i - 1] = x
        graph[x].forEach { a ->
            if (--inDegree[a] == 0) {
                q.add(a)
            }
        }
    }
    return result
}