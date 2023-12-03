package boj.depth_first_search

/**
 * 문제 번호: (13023)
 * 문제 이름: (ABCDE)
 * 소요 시간(분): ()
 */

private const val MAX_SIZE = 5

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    var answer = 0
    for (i in 0 until n) {
        if (dfs(i, mutableListOf(i), graph)) {
            answer = 1
            break
        }
    }
    println(answer)
    close()
}

private fun dfs(x: Int, temp: MutableList<Int>, graph: Array<MutableList<Int>>): Boolean {
    if (temp.size == MAX_SIZE) {
        return true
    }

    var result = false
    for (a in graph[x]) {
        if (a !in temp) {
            temp.add(a)
            result = dfs(a, temp, graph)
            if (result) break
            temp.removeLast()
        }
    }

    return result
}