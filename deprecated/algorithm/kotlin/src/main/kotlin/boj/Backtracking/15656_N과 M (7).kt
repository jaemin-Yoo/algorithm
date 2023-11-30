package boj.Backtracking.N과M7

private val sb = StringBuilder()
lateinit var list: List<Int>
var n = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    list = readLine().split(" ").map { it.toInt() }.sorted()
    val ans = MutableList(m) { 0 }
    dfs(0, ans)
    print(sb.toString())
}

fun dfs(depth: Int, ans: MutableList<Int>) {
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