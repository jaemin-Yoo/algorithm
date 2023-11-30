package boj.Greedy.빵집3109

import java.util.Stack

private val graph = mutableListOf<MutableList<Char>>()

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    repeat(r) {
        val row = readln().toMutableList()
        graph.add(row)
    }

    val visited = MutableList(r) { MutableList(c) { false } }
    var result = 0
    for (i in 0 until r) {
        result += dfs(i, visited)
    }
    println(result)
}

fun dfs(startX: Int, visited: MutableList<MutableList<Boolean>>): Int {
    val stack = Stack<Pair<Int, Int>>()
    stack.add(startX to 0)

    visited[startX][0] = true
    while (stack.isNotEmpty()) {
        val (x, y) = stack.pop()
        visited[x][y] = true
        if (y == graph[0].lastIndex) {
            return 1
        }

        movePoint(x + 1, y + 1, visited, stack)
        movePoint(x, y + 1, visited, stack)
        movePoint(x - 1, y + 1, visited, stack)
    }

    return 0
}

fun movePoint(a: Int, b: Int, visited: MutableList<MutableList<Boolean>>, stack: Stack<Pair<Int, Int>>) {
    if (a in graph.indices && b in graph[0].indices && !visited[a][b] && graph[a][b] != 'x') {
        stack.add(a to b)
    }
}