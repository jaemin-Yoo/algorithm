package boj.Greedy

import java.util.Stack

val graph = mutableListOf<MutableList<Char>>()
lateinit var visited: Array<BooleanArray>
val di = listOf(-1, 0, 1)
var r = 0
var c = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (_r, _c) = readLine().split(" ").map{ it.toInt() }
    r = _r
    c = _c
    visited = Array(r) { BooleanArray(c) }
    repeat(r) {
        graph.add(readLine().toMutableList())
    }

    var cnt = 0
    for (i in 0 until r) {
        if (dfs(i to 0)) cnt += 1
    }
    visited.forEach {
        println(it.joinToString(" "))
    }
    println(cnt)

    close()
}

fun dfs(start: Pair<Int, Int>): Boolean {
    val stack = Stack<Pair<Int, Int>>()
    stack.add(start)
    visited[start.first][start.second] = true
    while (stack.isNotEmpty()) {
        val (x, y) = stack.pop()
        for (i in 0 until 3) {
            val a = x + di[i]
            val b = y + 1
            if (a in 0 until r
                && b in 0 until c
                && graph[a][b] == '.'
                && !visited[a][b]) {
                println(a to b)
                stack.add(a to b)
                visited[a][b] = true
                if (b == c - 1) return true
            }
        }
    }

    return false
}