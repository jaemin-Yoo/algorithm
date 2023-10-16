package boj.Breadth_first_Search.효율적인해킹1325

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = List(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        list[b].add(a)
    }

    val newList = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val visited = BooleanArray(n + 1)
        newList.add(bfs(i, list, visited))
    }

    val maxDist = newList.maxOf { it.second }
    val result = newList.filter { it.second == maxDist }.map { it.first }
    print(result.joinToString(" "))

    close()
}

fun bfs(start: Int, list: List<MutableList<Int>>, visited: BooleanArray): Pair<Int, Int> {
    val q: Queue<Int> = LinkedList()
    q.add(start)
    visited[start] = true

    var cnt = 1
    while (q.isNotEmpty()) {
        val x = q.poll()
        for (i in list[x]) {
            if (!visited[i]) {
                q.add(i)
                visited[i] = true
                cnt += 1
            }
        }
    }

    return start to cnt
}