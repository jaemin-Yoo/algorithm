package boj.Backtracking.감시15683

import kotlin.math.min

private var result = Int.MAX_VALUE
private const val WALL = 6
private const val CHECK = -1

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<MutableList<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }.toMutableList()
        graph.add(row)
    }

    val cctvList = mutableListOf<CCTV>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] in 1..5) {
                cctvList.add(CCTV(i, j, graph[i][j]))
            }
        }
    }

    backtracking(graph, 0, cctvList)
    print(result)
    close()
}

fun backtracking(graph: MutableList<MutableList<Int>>, idx: Int, cctvList: MutableList<CCTV>) {
    if (idx == cctvList.size) {
        result = min(result, countBlindSpot(graph))
        return
    }

    val cctv = cctvList[idx]
    val directionList = getDirectionList(cctv.num)
    for (direction in directionList) {
        val newGraph = graph.map { it.toMutableList() }.toMutableList()
        for (d in direction) {
            settingSurveillanceArea(cctv.x, cctv.y, d, newGraph)
        }
        backtracking(newGraph, idx + 1, cctvList)
    }
}

fun countBlindSpot(graph: MutableList<MutableList<Int>>): Int {
    var cnt = 0
    graph.forEach { row ->
        row.forEach {
            if (it == 0) {
                cnt += 1
            }
        }
    }
    return cnt
}

fun getDirectionList(num: Int): MutableList<MutableList<Direction>> {
    val directionList = mutableListOf<MutableList<Direction>>()
    when (num) {
        1 -> {
            directionList.add(mutableListOf(Direction.TOP))
            directionList.add(mutableListOf(Direction.END))
            directionList.add(mutableListOf(Direction.BOTTOM))
            directionList.add(mutableListOf(Direction.START))
        }
        2 -> {
            directionList.add(mutableListOf(Direction.START, Direction.END))
            directionList.add(mutableListOf(Direction.TOP, Direction.BOTTOM))
        }
        3 -> {
            directionList.add(mutableListOf(Direction.TOP, Direction.END))
            directionList.add(mutableListOf(Direction.END, Direction.BOTTOM))
            directionList.add(mutableListOf(Direction.BOTTOM, Direction.START))
            directionList.add(mutableListOf(Direction.START, Direction.TOP))
        }
        4 -> {
            directionList.add(mutableListOf(Direction.START, Direction.TOP, Direction.END))
            directionList.add(mutableListOf(Direction.TOP, Direction.END, Direction.BOTTOM))
            directionList.add(mutableListOf(Direction.END, Direction.BOTTOM, Direction.START))
            directionList.add(mutableListOf(Direction.BOTTOM, Direction.START, Direction.TOP))
        }
        5 -> directionList.add(mutableListOf(Direction.START, Direction.TOP, Direction.END, Direction.BOTTOM))
    }
    return directionList
}

fun settingSurveillanceArea(x: Int, y: Int, direction: Direction, graph: MutableList<MutableList<Int>>) {
    val n = graph.size
    val m = graph[0].size
    var a = x
    var b = y

    while (true) {
        when (direction) {
            Direction.TOP -> a -= 1
            Direction.END -> b += 1
            Direction.BOTTOM -> a += 1
            Direction.START -> b -= 1
        }

        if (a in 0 until n && b in 0 until m && graph[a][b] != WALL) {
            if (graph[a][b] == 0) {
                graph[a][b] = CHECK
            }
        } else {
            break
        }
    }
}

data class CCTV(
    val x: Int,
    val y: Int,
    val num: Int
)

enum class Direction {
    TOP, START, BOTTOM, END
}