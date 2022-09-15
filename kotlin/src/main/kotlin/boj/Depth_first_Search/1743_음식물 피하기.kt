package boj.Depth_first_Search

import java.util.*

class 음식물피하기1743 {
    lateinit var graph: Array<Array<Int>>
    val dx = listOf(0, 0, -1, 1)
    val dy = listOf(-1, 1, 0, 0)
    var n = 0
    var m = 0
    fun main() {
        val (_n, _m, k) = readln().split(" ").map { it.toInt() }
        n = _n
        m = _m
        graph = Array(n) { Array(m) { 0 } }
        repeat(k) {
            val (r, c) = readln().split(" ").map { it.toInt() }
            graph[r - 1][c - 1] = 1
        }

        var maxCnt = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (graph[i][j] == 1) {
                    val cnt = dfs(i to j)
                    if (maxCnt < cnt) {
                        maxCnt = cnt
                    }
                }
            }
        }
        println(maxCnt)
    }

    fun dfs(start: Pair<Int, Int>): Int {
        val stack = Stack<Pair<Int, Int>>()
        stack.add(start)

        var cnt = 0
        while (stack.isNotEmpty()) {
            val (x, y) = stack.pop()
            for (i in 0 until 4) {
                val a = x + dx[i]
                val b = y + dy[i]
                if (a in 0 until n
                    && b in 0 until m
                    && graph[a][b] == 1) {
                    graph[a][b] = 0
                    stack.add(a to b)
                    cnt += 1
                }
            }
        }

        return cnt
    }
}