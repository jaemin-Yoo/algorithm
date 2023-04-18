package boj.Bruteforcing.한윤정

private var count = 0
private lateinit var arr: IntArray
private lateinit var visited: BooleanArray
private lateinit var comb: Array<BooleanArray>
private lateinit var ans: IntArray
private var n = 0
private var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (nn, mm) = readLine().split(" ").map { it.toInt() }
    n = nn
    m = mm
    arr = IntArray(n + 1)
    visited = BooleanArray(n + 1)
    ans = IntArray(3)
    comb = Array(n + 1) { BooleanArray(n + 1) }

    for (i in 1 until n + 1) {
        arr[i - 1] = i
    }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        comb[a][b] = true
        comb[b][a] = true
    }

    dfs(0, 0)

    println(count)

    close()
}

fun dfs(start: Int, depth: Int) {
    if (depth == 3) {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (comb[ans[i]][ans[j]]) return
            }
        }

        count += 1
        return
    }

    for (i in start until n) {
        if (visited[i]) continue

        visited[i] = true
        ans[depth] = arr[i]
        dfs(i + 1, depth + 1)
        visited[i] = false
    }
}