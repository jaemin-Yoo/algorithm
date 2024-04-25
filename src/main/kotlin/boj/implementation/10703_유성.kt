package boj.implementation

/**
 * 문제 번호: (10703)
 * 문제 이름: (유성)
 * 소요 시간(분): (32)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val (r, s) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(r) { CharArray(s) }
    repeat(r) { i ->
        val row = br.readLine().toCharArray()
        graph[i] = row
    }

    val diff = getMinDiff(graph, r, s)
    fallMeteor(graph, diff, r, s)
    printGraph(graph)
}

private fun getMinDiff(graph: Array<CharArray>, r: Int, s: Int): Int {
    var minDiff = r - 1
    for (j in 0 until s) {
        var diff = 0
        for (i in r - 2 downTo 0) {
            if (graph[i][j] == 'X') {
                minDiff = min(minDiff, diff)
                break
            } else if (graph[i][j] == '#') {
                diff = 0
            } else {
                diff++
            }
        }
    }
    return minDiff
}

private fun fallMeteor(graph: Array<CharArray>, diff: Int, r: Int, s: Int) {
    for (j in 0 until s) {
        val colList = graph.map { it[j] }
        if (!colList.contains('X')) continue

        val end = colList.indexOfLast { it == 'X' }
        val newColList = Array(diff) { '.' } + colList.subList(0, end + 1)
        for (i in newColList.indices) {
            graph[i][j] = newColList[i]
        }
    }
}

private fun printGraph(graph: Array<CharArray>) {
    graph.forEach {
        println(it.joinToString(""))
    }
}