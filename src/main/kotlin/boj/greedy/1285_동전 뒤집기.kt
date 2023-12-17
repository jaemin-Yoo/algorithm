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
        flipRow(n, b, graph)
        val cnt = countT(n, graph)
        mnCnt = min(mnCnt, cnt)
        flipRow(n, b, graph)
    }
    println(mnCnt)

    close()
}

private fun flipRow(n: Int, rowBit: Int, graph: MutableList<MutableList<Char>>) {
    for (i in 0 until n) {
        if (rowBit and (1 shl i) != 0) {
            for (j in graph[i].indices) {
                if (graph[i][j] == 'T') {
                    graph[i][j] = 'H'
                } else {
                    graph[i][j] = 'T'
                }
            }
        }
    }
}

private fun countT(n: Int, graph: List<List<Char>>): Int {
    var result = 0
    for (j in 0 until n) {
        var cnt = 0
        graph.forEach { row ->
            if (row[j] == 'T') {
                cnt += 1
            }
        }
        result += min(n - cnt, cnt)
    }
    return result
}