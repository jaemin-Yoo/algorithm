package boj.topological_sorting

/**
 * 문제 번호: (2056)
 * 문제 이름: (작업)
 * 소요 시간(분): (27)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tasks = IntArray(n + 1)
    val inDegree = IntArray(n + 1)
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val times = IntArray(n + 1)
    for (i in 1 until n + 1) {
        val input = readLine().split(" ").map { it.toInt() }
        tasks[i] = input[0]
        inDegree[i] = input[1]
        for (j in 2 until input.size) {
            val x = input[j]
            graph[x].add(i)
        }
    }
    val result = getElapsedTime(graph, inDegree, tasks, times, n)
    println(result)

    close()
}

private fun getElapsedTime(graph: Array<MutableList<Int>>, inDegree: IntArray, tasks: IntArray, times: IntArray, n: Int): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            times[i] = tasks[i]
            q.add(i to tasks[i])
        }
    }

    while (q.isNotEmpty()) {
        val (x, time) = q.poll()
        graph[x].forEach { a ->
            val newTime = time + tasks[a]
            if (newTime > times[a]) {
                times[a] = newTime
            }
            if (--inDegree[a] == 0) {
                q.add(a to times[a])
            }
        }
    }

    return times.maxOf { it }
}