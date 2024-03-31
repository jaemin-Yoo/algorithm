package boj.implementation

/**
 * 문제 번호: (17829)
 * 문제 이름: (222-풀링)
 * 소요 시간(분): (15)
 */

import kotlin.math.log2

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    var graph = Array(n) { IntArray(n) }
    repeat(n) { i ->
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[i] = row
    }

    for (i in 0 until log2(n.toFloat()).toInt()) {
        graph = pooling(graph)
    }
    println(graph[0][0])
}

private fun pooling(graph: Array<IntArray>): Array<IntArray> {
    val n = graph.size
    val newGraph = Array(n / 2) { IntArray(n / 2) }
    for (i in 0 until n step 2) {
        for (j in 0 until n step 2) {
            val lst = listOf(graph[i][j], graph[i + 1][j], graph[i][j + 1], graph[i + 1][j + 1]).sortedDescending()
            newGraph[i / 2][j / 2] = lst[1]
        }
    }
    return newGraph
}