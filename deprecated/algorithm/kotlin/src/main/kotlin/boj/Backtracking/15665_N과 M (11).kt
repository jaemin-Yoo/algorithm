package boj.Backtracking.N과M11

lateinit var list: List<Int>
val sb = StringBuilder()
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map { it.toInt() }
    list = readLine().split(" ").map { it.toInt() }.sorted().distinct()
    n = list.size
    m = _m
    val ans = IntArray(m)
    dfs(0, ans)
    print(sb.toString())

    close()
}

fun dfs(depth: Int, ans: IntArray) {
    if (depth == m) {
        sb.append(ans.joinToString(" "))
        sb.append("\n")
        return
    }

    for (i in 0 until n) {
        ans[depth] = list[i]
        dfs(depth + 1, ans)
    }
}