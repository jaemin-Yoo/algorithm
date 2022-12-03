package boj.Bruteforcing.치킨배달15686

val graph = mutableListOf<MutableList<Int>>()
val selected = mutableListOf<MutableList<Pair<Int, Int>>>()
val chicken = mutableListOf<Pair<Int, Int>>()
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m
    repeat(n) {
        graph.add(readLine().split(" ").map { it.toInt() }.toMutableList())
    }

    val home = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            when (graph[i][j]) {
                1 -> home.add(i to j)
                2 -> chicken.add(i to j)
            }
        }
    }

    dfs(0, 0, mutableListOf())
    selected.forEach {
        println(it.joinToString(" "))
    }

    close()
}

fun dfs(start: Int, depth: Int, ans: MutableList<Pair<Int, Int>>) {
    if (depth == m) {
        selected.add(ans.toMutableList())
        return
    }

    for (i in start until chicken.size) {
        ans.add(chicken[i])
        dfs(i + 1, depth + 1, ans)
        ans.removeLast()
    }
}