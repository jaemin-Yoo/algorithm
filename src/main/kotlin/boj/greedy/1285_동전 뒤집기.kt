package boj.greedy

/**
 * 문제 번호: (1285)
 * 문제 이름: (동전 뒤집기)
 * 소요 시간(분): (x)
 */

import kotlin.math.min
import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = mutableListOf<MutableList<Char>>()
    repeat(n) {
        val row = readLine().toMutableList()
        graph.add(row)
    }

    var mnCnt = Int.MAX_VALUE
    for (b in 0 until 2.0.pow(n).toInt()) {
        val newGraph = flipRow(n, b, graph)
        val cnt = countT(n, newGraph)
        mnCnt = min(mnCnt, cnt)
    }
    println(mnCnt)

    close()
}

private fun flipRow(n: Int, rowBit: Int, graph: MutableList<MutableList<Char>>): MutableList<MutableList<Char>> {
    val newGraph = graph.map { it.toMutableList() }.toMutableList()
    for (i in 0 until n) {
        if (rowBit and i == 1) {
            for (j in newGraph[i].indices) {
                if (newGraph[i][j] == 'T') {
                    newGraph[i][j] = 'H'
                } else {
                    newGraph[i][j] = 'T'
                }
            }
        }
    }
    return newGraph
}

private fun countT(n: Int, graph: List<List<Char>>): Int {
    var result = 0
    for (j in 0 until n) {
        val colList = graph.map { it[j] }
        val cnt = colList.count { it == 'T' }
        result += min(n - cnt, cnt)
    }
    return result
}