package boj.topological_sorting

import java.util.Queue
import java.util.LinkedList

fun main() {
    val n = 3
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val inDegree = IntArray(n + 1)

    graph[1].add(3)
    inDegree[3]++

    graph[2].add(3)
    inDegree[3]++

    val result = topologySort(graph, inDegree, n)
    println(result.joinToString(" "))
}

private fun topologySort(graph: Array<MutableList<Int>>, inDegree: IntArray, n: Int): IntArray {
    val q: Queue<Int> = LinkedList()

    // 진입 차수가 0인 노드를 큐에 삽입합니다.
    for (i in 1 until n + 1) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    // 위상 정렬이 완전히 수행되려면 정확히 N개의 노드를 방문해야한다.
    val result = IntArray(n)
    for (i in 1 until n + 1) {
        // N개의 노드를 모두 방문하기 전에 큐가 비어있다면 사이클이 발생한 것이다.
        if (q.isEmpty()) {
            throw Exception("사이클 발생")
        }

        val x = q.poll()
        result[i - 1] = x
        graph[x].forEach { a ->
            // 연결된 노드의 간선을 제거한 후 진입 차수가 0이 된 노드를 다시 큐에 삽입한다.
            if (--inDegree[a] == 0) {
                q.add(a)
            }
        }
    }

    return result
}