package boj.topological_sorting

/**
 * 문제 번호: (3665)
 * 문제 이름: (최종 순위)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }
        val initRank = IntArray(n + 1)
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val inDegree = IntArray(n + 1)
        for (i in 0 until n) {
            inDegree[arr[i]] = i
            initRank[arr[i]] = i + 1
            for (j in i + 1 until n) {
                graph[arr[i]].add(arr[j])
            }
        }
        val m = readLine().toInt()
        repeat(m) {
            val (a, b) = readLine().split(" ").map { it.toInt() }
            if (initRank[a] > initRank[b]) {
                graph[a].add(b)
                graph[b].remove(a)
                inDegree[a]--
                inDegree[b]++
            } else {
                graph[b].add(a)
                graph[a].remove(b)
                inDegree[b]--
                inDegree[a]++
            }
        }

        val result = topologicalSort(arr, graph, inDegree, n)
        println(result)
    }

    close()
}

private fun topologicalSort(arr: List<Int>, graph: Array<MutableList<Int>>, inDegree: IntArray, n: Int): String {
    val q: Queue<Int> = LinkedList()
    for (i in 0 until n) {
        val a = arr[i]
        if (inDegree[a] == 0) {
            q.add(a)
            break
        }
    }

    val result = IntArray(n)
    for (i in 0 until n) {
        if (q.isEmpty()) {
            return "IMPOSSIBLE"
        }

        val a = q.poll()
        result[i] = a
        graph[a].forEach { x ->
            if (--inDegree[x] == 0) {
                q.add(x)
                return@forEach
            }
        }
    }

    return result.joinToString(" ")
}