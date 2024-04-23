package boj.implementation

/**
 * 문제 번호: (14890)
 * 문제 이름: (경사로)
 * 소요 시간(분): (66)
 */

import kotlin.math.abs

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, l) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(n) { IntArray(n) }
    repeat(n) {
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        graph[it] = row
    }

    var cnt = 0
    for (i in 0 until n) {
        if (isRoad(graph[i].toList(), n, l)) {
            cnt++
        }
        if (isRoad(graph.map { it[i] }, n, l)) {
            cnt++
        }
    }
    println(cnt)
}

private fun isRoad(line: List<Int>, n: Int, l: Int): Boolean {
    var idx = 0
    while (idx < n) {
        val (i, cnt) = getSameHeightCount(line, idx, n)
        if (idx > 0 && cnt < l && line[idx - 1] > line[i - 1]) {
            return false
        }
        if (n == i) {
            break
        }
        if ((cnt < l && line[i - 1] < line[i]) || (abs(line[i] - line[i - 1]) > 1)) {
            return false
        }
        if (idx > 0 && line[idx - 1] == line[i] && line[i] - 1 == line[i - 1] && cnt < l * 2) {
            return false
        }
        idx = i
    }

    return true
}

private fun getSameHeightCount(line: List<Int>, idx: Int, n: Int): Pair<Int, Int> {
    val cell = line[idx]
    var i = idx + 1
    var cnt = 1
    while (i < n && cell == line[i]) {
        i++
        cnt++
    }
    return i to cnt
}