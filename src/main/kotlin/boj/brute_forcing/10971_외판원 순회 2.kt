package boj.brute_forcing

/**
 * 문제 번호: (10971)
 * 문제 이름: (외판원 순회 2)
 * 소요 시간(분): (23)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val w = Array(n) { IntArray(n) }
    repeat(n) {
        val row = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        w[it] = row
    }

    val distances = mutableListOf<Int>()
    for (i in 0 until n) {
        dfs(w, BooleanArray(n), distances, i, i, 0, n)
    }
    println(distances.minOf { it })
}

private fun dfs(w: Array<IntArray>, visited: BooleanArray, distances: MutableList<Int>, start: Int, a: Int, dist: Int, n: Int) {
    if (start == a && visited.all { it }) {
        distances.add(dist)
        return
    }

    for (b in 0 until n) {
        val newDist = dist + w[a][b]
        if (w[a][b] != 0 && !visited[b]) {
            visited[b] = true
            dfs(w, visited, distances, start, b, newDist, n)
            visited[b] = false
        }
    }
}