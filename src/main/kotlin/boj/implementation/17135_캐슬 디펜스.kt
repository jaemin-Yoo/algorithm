package boj.implementation

/**
 * 문제 번호: (17135)
 * 문제 이름: (캐슬 디펜스)
 * 소요 시간(분): (74)
 */

import kotlin.math.abs
import kotlin.math.max

private const val ENEMY = 1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, d) = readLine().split(" ").map{ it.toInt() }
    val initGraph = mutableListOf<IntArray>()
    repeat(n) {
        val row = readLine().split(" ").map{ it.toInt() }.toIntArray()
        initGraph.add(row)
    }

    var result = 0
    val apList = archerPositionList(n, m)
    apList.forEach { (a, b, c) ->
        val graph = initGraph.map { it.clone() }.toMutableList()

        var killedCnt = 0
        while (existsEnemy(graph)) {
            killedCnt += killEnemy(n, m, d, a, b, c, graph)
            moveEnemy(m, graph)
        }

        result = max(result, killedCnt)
    }
    println(result)

    close()
}

private fun archerPositionList(n: Int, m: Int): MutableList<List<Pair<Int, Int>>> {
    val list = mutableListOf<List<Pair<Int, Int>>>()
    for (i in 0 until m) {
        for (j in i + 1 until m) {
            for (k in j + 1 until m) {
                list.add(listOf(n to i, n to j, n to k))
            }
        }
    }

    return list
}

private fun findEnemyPosition(n: Int, m: Int, d: Int, archerPosition: Pair<Int, Int>, graph: MutableList<IntArray>): Pair<Int, Int>? {
    val (a_x, a_y) = archerPosition
    var minDist = Int.MAX_VALUE
    var enemyPosition: Pair<Int, Int>? = null
    for (i in n - 1 downTo 0) {
        for (j in 0 until m) {
            val dist = abs(i - a_x) + abs(j - a_y)
            val y = enemyPosition?.second ?: Int.MAX_VALUE
            if (graph[i][j] == ENEMY && dist <= d && (minDist > dist || (minDist == dist && y > j))) {
                minDist = dist
                enemyPosition = i to j
            }
        }
    }

    return enemyPosition
}

private fun killEnemy(n: Int, m: Int, d: Int, a: Pair<Int, Int>, b: Pair<Int, Int>, c: Pair<Int, Int>, graph: MutableList<IntArray>): Int {
    val eList = listOfNotNull(
        findEnemyPosition(n, m, d, a, graph),
        findEnemyPosition(n, m, d, b, graph),
        findEnemyPosition(n, m, d, c, graph)
    ).distinct()

    eList.forEach { (e_x, e_y) ->
        graph[e_x][e_y] = 0
    }

    return eList.size
}

private fun moveEnemy(m: Int, graph: MutableList<IntArray>) {
    graph.add(0, IntArray(m))
    graph.removeLast()
}

private fun existsEnemy(graph: MutableList<IntArray>): Boolean {
    graph.forEach {
        if (it.contains(ENEMY)) {
            return true
        }
    }

    return false
}