package boj.implementation

/**
 * 문제 번호: (5212)
 * 문제 이름: (지구 온난화)
 * 소요 시간(분): (40)
 */

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val graph = Array(r) { CharArray(c) }
    repeat(r) {
        val row = readLine().toCharArray()
        graph[it] = row
    }
    val newGraph = submergeIsland(graph, r, c)
    var y = Int.MAX_VALUE
    var b = -1
    for (i in 0 until r) {
        val startIdx = newGraph[i].indexOfFirst { it == 'X' }
        val endIdx = newGraph[i].indexOfLast { it == 'X' }
        if (y > startIdx && startIdx != -1) {
            y = startIdx
        }
        if (b < endIdx) {
            b = endIdx
        }
    }
    var x = Int.MAX_VALUE
    var a = -1
    for (i in 0 until c) {
        val startIdx = newGraph.map { it[i] }.indexOfFirst { it == 'X' }
        val endIdx = newGraph.map { it[i] }.indexOfLast { it == 'X' }
        if (x > startIdx && startIdx != -1) {
            x = startIdx
        }
        if (a < endIdx) {
            a = endIdx
        }
    }
    for (i in x..a) {
        val row = mutableListOf<Char>()
        for (j in y..b) {
            row.add(newGraph[i][j])
        }
        println(row.joinToString(""))
    }
    close()
}

private fun submergeIsland(graph: Array<CharArray>, r: Int, c: Int): Array<CharArray> {
    val newGraph = graph.map { it.clone() }.toTypedArray()
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == 'X') {
                var cnt = 0
                for (k in 0 until 4) {
                    val x = i + dx[k]
                    val y = j + dy[k]
                    if ((x in 0 until r && y in 0 until c && graph[x][y] == '.') || (x !in 0 until r || y !in 0 until c)) cnt++
                }

                if (cnt >= 3) {
                    newGraph[i][j] = '.'
                }
            }
        }
    }
    return newGraph
}