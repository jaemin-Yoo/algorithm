package boj.implementation

/**
 * 문제 번호: (17144)
 * 문제 이름: (미세먼지 안녕!)
 * 소요 시간(분): (58)
 */

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, t) = readLine().split(" ").map { it.toInt() }
    val graph = Array(r) { IntArray(c) }
    repeat(r) { i ->
        val row = readLine().split(" ").map { it.toInt() }.toIntArray()
        graph[i] = row
    }

    var newGraph = graph.map { it.clone() }.toTypedArray()
    repeat(t) {
        newGraph = afterOneSecond(r, c, newGraph)
    }

    var answer = 0
    newGraph.forEach { row ->
        answer += row.filter { it != -1 }.sum()
    }
    println(answer)
    close()
}

private fun printGraph(graph: Array<IntArray>) {
    graph.forEach {
        println(it.contentToString())
    }
    println()
}

private fun afterOneSecond(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val g1 = spreadFineDust(r, c, graph)
    return operateAirPurifier(r, c, g1)
}

private fun spreadFineDust(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val newGraph = Array(r) { IntArray(c) }
    for (i in 0 until r) {
        for (j in 0 until c) {
            var n = graph[i][j]
            val x = n / 5
            if (x == 0) {
                newGraph[i][j] += n
                continue
            }

            for (k in 0 until 4) {
                val a = i + dx[k]
                val b = j + dy[k]
                if (a in 0 until r && b in 0 until c && graph[a][b] != -1) {
                    newGraph[a][b] += x
                    n -= x
                }
            }
            newGraph[i][j] += n
        }
    }

    return newGraph
}

private fun operateAirPurifier(r: Int, c: Int, graph: Array<IntArray>): Array<IntArray> {
    val newGraph = graph.map { it.clone() }.toTypedArray()
    val position = getAirPurifierPosition(r, c, graph)
    val (x, y) = position[0]
    val (a, b) = position[1]

    for (i in 1 until x + 1) {
        if (i != x) {
            newGraph[i][0] = graph[i - 1][0]
        }
        newGraph[i - 1][c - 1] = graph[i][c - 1]
    }

    for (i in a until r - 1) {
        if (i != a) {
            newGraph[i][0] = graph[i + 1][0]
        }
        newGraph[i + 1][c - 1] = graph[i][c - 1]
    }

    for (j in 1 until c) {
        newGraph[0][j - 1] = graph[0][j]
        if (j != 1) {
            newGraph[x][j] = graph[x][j - 1]
            newGraph[a][j] = graph[a][j - 1]
        }
        newGraph[r - 1][j - 1] = graph[r - 1][j]
    }

    newGraph[x][1] = 0
    newGraph[a][1] = 0

    return newGraph
}

private fun getAirPurifierPosition(r: Int, c: Int, graph: Array<IntArray>): Array<Pair<Int, Int>> {
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == -1) {
                return arrayOf(i to j, i + 1 to j)
            }
        }
    }

    return arrayOf()
}