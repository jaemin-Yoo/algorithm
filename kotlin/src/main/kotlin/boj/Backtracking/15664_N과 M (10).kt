package boj.Backtracking.N과M10

val result = mutableSetOf<String>()
lateinit var list: List<Int>
var n = 0
var m = 0
fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    n = _n
    m = _m
    list = readLine().split(" ").map { it.toInt() }.sorted()

    dfs(0, 0, IntArray(m))
    result.forEach {
        println(it)
    }
    close()
}

fun dfs(start: Int, depth: Int, ans: IntArray) {
    if (depth == m) {
        result.add(ans.joinToString(" "))
        return
    }

    for (i in start until n) {
        ans[depth] = list[i]
        dfs(i + 1, depth + 1, ans)
    }
}