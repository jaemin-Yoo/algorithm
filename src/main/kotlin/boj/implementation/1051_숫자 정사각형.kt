package boj.implementation

/**
 * 문제 번호: (1051)
 * 문제 이름: (숫자 정사각형)
 * 소요 시간(분): (15)
 */

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<String>()
    repeat(n) {
        val row = readLine()
        graph.add(row)
    }

    var result = 1
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (k in 1 until max(n, m)) {
                if (i + k >= n || j + k >= m) break

                if (graph[i][j] == graph[i + k][j + k] && graph[i][j] == graph[i][j + k] && graph[i][j] == graph[i + k][j]) {
                    val area = (k + 1) * (k + 1)
                    result = max(result, area)
                }
            }
        }
    }
    println(result)
    close()
}