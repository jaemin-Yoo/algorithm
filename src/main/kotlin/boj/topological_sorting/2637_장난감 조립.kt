package boj.topological_sorting

/**
 * 문제 번호: (2637)
 * 문제 이름: (장난감 조립)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val inDegree = IntArray(n + 1)
    repeat(m) {
        val (x, y, k) = br.readLine().split(' ').map { it.toInt() }
        graph[x].add(y to k)
        inDegree[y]++
    }

    val needCount = topologicalSort(graph, inDegree, n)
    for (i in 1 until n + 1) {
        if (needCount[i] != 0) {
            println("$i ${needCount[i]}")
        }
    }
}

private fun topologicalSort(graph: Array<MutableList<Pair<Int, Int>>>, inDegree: IntArray, n: Int): IntArray {
    val q: Queue<Int> = LinkedList()
    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    val needCount = IntArray(n + 1)
    needCount[n] = 1
    for (i in 1 until n + 1) {
        val x = q.poll()
        if (graph[x].isEmpty()) continue

        graph[x].forEach { (y, k) ->
            needCount[y] += needCount[x] * k
            if (--inDegree[y] == 0) {
                q.add(y)
            }
        }
        needCount[x] = 0
    }

    return needCount
}