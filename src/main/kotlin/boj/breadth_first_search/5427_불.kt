package boj.breadth_first_search

/**
 * 문제 번호: (5427)
 * 문제 이름: (불)
 * 소요 시간(분): (44)
 */

private data class Position(
    val x: Int,
    val y: Int,
    val time: Int
)

private val dx = listOf(-1, 0, 1, 0)
private val dy = listOf(0, 1, 0, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    repeat(t) {
        val (m, n) = br.readLine().split(' ').map { it.toInt() }
        val graph = Array(n) { CharArray(m) }
        repeat(n) {
            val row = br.readLine().toCharArray()
            graph[it] = row
        }

        val start = getStartPosition(graph, n, m)
        val fireGraph = getSpreadFireGraph(graph, n, m)
        val result = getEscapeTime(graph, fireGraph, start, n, m)
        println(result)
    }
}

private fun getStartPosition(graph: Array<CharArray>, n: Int, m: Int): Position {
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == '@') {
                return Position(i, j, 0)
            }
        }
    }

    throw Exception("No start position")
}

private fun getSpreadFireGraph(graph: Array<CharArray>, n: Int, m: Int): Array<IntArray> {
    val q = ArrayDeque<Position>()
    val fireGraph = Array(n) { IntArray(m) { Int.MAX_VALUE } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == '*') {
                fireGraph[i][j] = 0
                q.add(Position(i, j, 0))
            }
        }
    }

    while (q.isNotEmpty()) {
        val (x, y, t) = q.removeFirst()
        for (k in 0 until 4) {
            val a = x + dx[k]
            val b = y + dy[k]
            val nextTime = t + 1
            if (a in 0 until n && b in 0 until m && graph[a][b] != '#' && fireGraph[a][b] == Int.MAX_VALUE) {
                fireGraph[a][b] = nextTime
                q.add(Position(a, b, nextTime))
            }
        }
    }

    return fireGraph
}

private fun getEscapeTime(graph: Array<CharArray>, fireGraph: Array<IntArray>, start: Position, n: Int, m: Int): String {
    val q = ArrayDeque<Position>()
    q.add(start)

    while (q.isNotEmpty()) {
        val (x, y, t) = q.removeFirst()
        for (k in 0 until 4) {
            val a = x + dx[k]
            val b = y + dy[k]
            val nextTime = t + 1
            if (a !in 0 until n || b !in 0 until m) {
                return nextTime.toString()
            } else if (graph[a][b] == '.' && fireGraph[a][b] > nextTime) {
                graph[a][b] = '@'
                q.add(Position(a, b, nextTime))
            }
        }
    }

    return "IMPOSSIBLE"
}

/*

1
10 5
##########
#@....#*.#
#.....#..#
#.....#..#
##.#######

 */