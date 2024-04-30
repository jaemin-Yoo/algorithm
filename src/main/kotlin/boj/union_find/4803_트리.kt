package boj.union_find

/**
 * 문제 번호: (4803)
 * 문제 이름: (트리)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    var testNum = 1
    while (true) {
        val (n, m) = br.readLine().split(' ').map { it.toInt() }
        if (n to m == 0 to 0) break

        val graph = Array(n + 1) { mutableListOf<Int>() }
        repeat(m) {
            val (a, b) = br.readLine().split(' ').map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }
        val count = countTree(graph, n)
        val result = if (count > 1) {
            "A forest of $count trees."
        } else if (count == 1) {
            "There is one tree."
        } else {
            "No trees."
        }
        println("Case ${testNum++}: $result")
    }
}

private fun countTree(graph: Array<MutableList<Int>>, n: Int): Int {
    val visited = BooleanArray(n + 1)
    var count = 0
    for (i in 1 until n + 1) {
        if (isTreeSet(graph, visited, i)) {
            count++
        }
    }
    return count
}

private fun isTreeSet(graph: Array<MutableList<Int>>, visited: BooleanArray, start: Int): Boolean {
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(start to 0)
    visited[start] = true

    var isTreeSet = true
    while (q.isNotEmpty()) {
        val (node, prev) = q.removeFirst()
        graph[node].forEach { next ->
            if (next == prev) {
                return@forEach
            }

            if (visited[next]) {
                isTreeSet = false
            } else {
                visited[next] = true
                q.add(next to node)
            }
        }
    }
    return isTreeSet
}