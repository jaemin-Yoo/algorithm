package boj.Bruteforcing

import kotlin.math.max

val list = mutableListOf<List<Int>>()
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        graph.add(readLine().split(" ").map { it.toInt() })
    }

    dfs(0, 0, IntArray(3))
    var mxResult = 0
    list.forEach { (a, b, c) ->
        var result = 0
        graph.forEach { row ->
            val mx = max(row[a], row[b])
            result += max(mx, row[c])
        }
        mxResult = max(mxResult, result)
    }
    println(mxResult)

    close()
}

fun dfs(start: Int, depth: Int, ans: IntArray) {
    if (depth == 3) {
        list.add(ans.toList())
        return
    }

    for (i in start until m) {
        ans[depth] = i
        dfs(i + 1, depth + 1, ans)
    }
}