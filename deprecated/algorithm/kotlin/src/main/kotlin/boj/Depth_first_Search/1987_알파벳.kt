package boj.Depth_first_Search.알파벳1987

private val graph = mutableListOf<MutableList<Char>>()
private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1 ,1)
private val alphabet = MutableList(26) { false }
private var max = 0

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    repeat(r) {
        val row = readln().toMutableList()
        graph.add(row)
    }
    val visited = MutableList(r) { MutableList(c) { false } }
    visited[0][0] = true
    alphabet[getAlphabetIndex(0, 0)] = true
    dfs(0, 0, 1, visited)
    println(max)
}

fun dfs(x: Int, y: Int, dist: Int, visited: MutableList<MutableList<Boolean>>) {
    if (dist > max) {
        max = dist
    }

    for (i in 0 until 4) {
        val a = x + dx[i]
        val b = y + dy[i]
        if (a in graph.indices && b in graph[0].indices && !visited[a][b] && !alphabet[getAlphabetIndex(a, b)]) {
            visited[a][b] = true
            alphabet[getAlphabetIndex(a, b)] = true
            dfs(a, b, dist + 1, visited)
            visited[a][b] = false
            alphabet[getAlphabetIndex(a, b)] = false
        }
    }
}

fun getAlphabetIndex(x: Int, y: Int): Int = graph[x][y].code - 65