package boj.Depth_first_Search

import java.util.*

class 숫자판점프2210 {
    val graph = mutableListOf<MutableList<String>>()
    val result = mutableListOf<String>()
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    fun main() {
        repeat(5) {
            graph.add(readln().split(" ").toMutableList())
        }

        for (i in 0 until 5) {
            for (j in 0 until 5) {
                dfs(i to j, graph[i][j])
            }
        }

        println(result.count())
    }

    fun dfs(start: Pair<Int, Int>, s: String) {
        if (s.length == 6) {
            if (s !in result) {
                result.add(s)
            }
            return
        }

        val x = start.first
        val y = start.second
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until 5
                && b in 0 until 5) {
                dfs(a to b, s + graph[a][b])
            }
        }
    }

    fun dfs2(start: Pair<Int, Int>, ss: String) {
        val stack = Stack<Triple<Int, Int, String>>()
        stack.add(Triple(start.first, start.second, ss))
        while (stack.isNotEmpty()) {
            val (x, y, s) = stack.pop()
            if (s.length == 6) {
                if (s !in result) {
                    result.add(s)
                }
                continue
            }
            for (i in 0 until 4) {
                val a = x + dx[i]
                val b = y + dy[i]
                if (a in 0 until 5
                    && b in 0 until 5) {
                    stack.add(Triple(a, b, s + graph[a][b]))
                }
            }
        }
    }
}