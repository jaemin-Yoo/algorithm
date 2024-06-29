package boj.implementation

/**
 * 문제 번호: (20125)
 * 문제 이름: (쿠키의 신체 측정)
 * 소요 시간(분): (12)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val graph = Array(n) { CharArray(n) }
    repeat(n) { i ->
        val row = br.readLine().toCharArray()
        graph[i] = row
    }
    val (x, y) = getHeartPosition(graph, n)

    var cnt = 0
    for (j in 0 until y) {
        if (graph[x][j] == '*') {
            cnt++
        }
    }
    val la = cnt

    cnt = 0
    for (j in y + 1 until n) {
        if (graph[x][j] == '*') {
            cnt++
        }
    }
    val ra = cnt

    cnt = 0
    for (i in x + 1 until n) {
        if (graph[i][y] == '*') {
            cnt++
        } else {
            break
        }
    }
    val b = cnt

    cnt = 0
    for (i in x + b + 1 until n) {
        if (graph[i][y - 1] == '*') {
            cnt++
        }
    }
    val lc = cnt

    cnt = 0
    for (i in x + b + 1 until n) {
        if (graph[i][y + 1] == '*') {
            cnt++
        }
    }
    val rc = cnt

    println("${x + 1} ${y + 1}")
    println("$la $ra $b $lc $rc")
}

private fun getHeartPosition(graph: Array<CharArray>, n: Int): Pair<Int, Int> {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == '*') {
                return i + 1 to j
            }
        }
    }

    return -1 to -1
}