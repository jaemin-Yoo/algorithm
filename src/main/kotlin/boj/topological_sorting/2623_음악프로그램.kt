package boj.topological_sorting

/**
 * 문제 번호: (2623)
 * 문제 이름: (음악프로그램)
 * 소요 시간(분): (15)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)
    repeat(m) {
        val row = readLine().split(" ").map { it.toInt() }
        for (i in 1 until row.size - 1) {
            val a = row[i]
            val b = row[i + 1]
            graph[a].add(b)
            inDegree[b]++
        }
    }

    val sortedList = topologicalSort(graph, inDegree, n)
    sortedList.forEach {
        println(it)
    }
    close()
}

private fun topologicalSort(graph: Array<MutableList<Int>>, inDegree: IntArray, n: Int): List<Int> {
    val q: Queue<Int> = LinkedList()
    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    val result = mutableListOf<Int>()
    for (i in 0 until n) {
        if (q.isEmpty()) {
            return listOf(0)
        }

        val x = q.poll()
        result.add(x)
        graph[x].forEach { a ->
            if (--inDegree[a] == 0) {
                q.add(a)
            }
        }
    }

    return result
}