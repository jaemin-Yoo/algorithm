package boj.Depth_first_Search.트리1068

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val parentList = readLine().split(" ").map { it.toInt() }
    val removeNode = readLine().toInt()
    val graph = Array(n) { mutableListOf<Int>() }

    parentList.forEachIndexed { index, node ->
        if (node == -1 || index == removeNode) return@forEachIndexed

        graph[node].add(index)
    }

    if (parentList[removeNode] == -1) {
        println(0)
    } else {
        val result = dfs(graph, parentList.indexOf(-1))
        println(result)
    }

    close()
}

private fun dfs(graph: Array<MutableList<Int>>, start: Int): Int {
    val stack = Stack<Int>()
    stack.add(start)

    var cnt = 0
    while (stack.isNotEmpty()) {
        val node = stack.pop()

        if (graph[node].isEmpty()) {
            cnt += 1
        }

        graph[node].forEach {
            stack.add(it)
        }
    }

    return cnt
}