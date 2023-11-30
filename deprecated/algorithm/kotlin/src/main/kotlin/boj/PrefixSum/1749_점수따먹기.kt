package boj.PrefixSum

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<MutableList<Int>>()
    repeat(n) {
        graph.add(readLine().split(" ").map { it.toInt() }.toMutableList())
    }

    val ps = Array(n + 1) { Array(m + 1) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            ps[i + 1][j + 1] = graph[i][j] - ps[i][j] + ps[i][j + 1] + ps[i + 1][j]
        }
    }

    var result = Int.MIN_VALUE
    for (i in 1 until n + 1) {
        for (j in 1 until m + 1) {
            for (ii in i until n + 1) {
                for (jj in j until m + 1) {
                    result = max(result, ps[ii][jj] - ps[ii][j - 1] - ps[i - 1][jj] + ps[i - 1][j - 1])
                }
            }
        }
    }
    println(result)
}