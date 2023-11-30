package boj.Bruteforcing.사다리조작15684

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, h) = readLine().split(" ").map { it.toInt() }
    val graph = Array(h + 1) { IntArray(n + 1) { it } }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        putLadder(a, b, graph)
    }

    val result = if (isSameAllResultNumber(n, h, graph)) {
        0
    } else {
        countPutLadder(n, h, graph)
    }
    println(result)

    close()
}

private fun countPutLadder(n: Int, h: Int, graph: Array<IntArray>): Int {
    val positionList = getPossiblePositionList(n, h, graph)

    for (i in 1 until min(positionList.size, 3) + 1) {
        if (comb(n, h, 0, 0, i, positionList, graph)) {
            return i
        }
    }
    return -1
}

private fun comb(n: Int, h: Int, start: Int, ladderCount: Int, maxCount: Int, positionList: MutableList<Pair<Int, Int>>, graph: Array<IntArray>): Boolean {
    if (ladderCount == maxCount) {
        return isSameAllResultNumber(n, h, graph)
    }

    for (i in start until positionList.size) {
        val (a, b) = positionList[i]
        if (!putLadder(a, b, graph)) continue
        if (comb(n, h, i + 1, ladderCount + 1, maxCount, positionList, graph)) return true
        removeLadder(a, b, graph)
    }

    return false
}

private fun resultNumber(num: Int, h: Int, graph: Array<IntArray>): Int {
    var pos = num
    for (i in 1 until h + 1) {
        pos = graph[i][pos]
    }
    return pos
}

private fun isSameAllResultNumber(n: Int, h: Int, graph: Array<IntArray>): Boolean {
    for (i in 1 until n) {
        val resultNumber = resultNumber(i, h, graph)
        if (resultNumber != i) return false
    }
    return true
}

private fun getPossiblePositionList(n: Int, h: Int, graph: Array<IntArray>): MutableList<Pair<Int, Int>> {
    val positionList = mutableListOf<Pair<Int, Int>>()
    for (i in 1 until h + 1) {
        for (j in 1 until n) {
            if (graph[i][j] == j && graph[i][j + 1] == j + 1) {
                positionList.add(i to j)
            }
        }
    }
    return positionList
}

private fun putLadder(a: Int, b: Int, graph: Array<IntArray>): Boolean {
    if (graph[a][b] == b && graph[a][b + 1] == b + 1) {
        graph[a][b] = b + 1
        graph[a][b + 1] = b
        return true
    }

    return false
}

private fun removeLadder(a: Int, b: Int, graph: Array<IntArray>) {
    if (graph[a][b] == b + 1 && graph[a][b + 1] == b) {
        graph[a][b] = b
        graph[a][b + 1] = b + 1
    }
}