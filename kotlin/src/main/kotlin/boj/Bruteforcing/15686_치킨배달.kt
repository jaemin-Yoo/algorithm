package boj.Bruteforcing.치킨배달15686

import kotlin.math.abs
import kotlin.math.min

val graph = mutableListOf<List<Int>>()
val selected = mutableListOf<List<Node>>()
val home = mutableListOf<Node>()
val chicken = mutableListOf<Node>()
var n = 0
var m = 0

data class Node(
    val x: Int,
    val y: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m
    repeat(n) {
        graph.add(readLine().split(" ").map { it.toInt() })
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            when (graph[i][j]) {
                1 -> home.add(Node(i, j))
                2 -> chicken.add(Node(i, j))
            }
        }
    }

    dfs(0, 0, Array(m) { Node(-1, -1) })
    var mnResult = Int.MAX_VALUE
    selected.forEach { chickens ->
        var s = 0
        home.forEach { (x, y) ->
            val mn = chickens.minOf { (a, b) ->
                abs(a - x) + abs(b - y)
            }
            s += mn
        }
        mnResult = min(mnResult, s)
    }
    println(mnResult)

    close()
}

fun dfs(start: Int, depth: Int, ans: Array<Node>) {
    if (depth == m) {
        selected.add(ans.toList())
        return
    }

    for (i in start until chicken.size) {
        ans[depth] = chicken[i]
        dfs(i + 1, depth + 1, ans)
    }
}