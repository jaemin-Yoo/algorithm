package boj.hashing

/**
 * 문제 번호: (1327)
 * 문제 이름: (소트 게임)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val s = readLine().split(" ").map { it.toInt() }
    val start = s.joinToString("")
    val expected = s.sorted().joinToString("")
    val visited = HashMap<String, Boolean>()
    val result = bfs(start, expected, k, visited)
    println(result)

    close()
}

private fun bfs(start: String, expected: String, k: Int, visited: HashMap<String, Boolean>): Int {
    val q: Queue<Pair<String, Int>> = LinkedList()
    q.add(start to 0)

    while (q.isNotEmpty()) {
        val (x, dist) = q.poll()
        if (x == expected) {
            return dist
        }

        for (i in 0 until x.length - k + 1) {
            val a = x.substring(0 until i) + x.substring(i until i + k).reversed() + x.substring(i + k until x.length)
            if (!visited.containsKey(a)) {
                visited[a] = true
                q.add(a to dist + 1)
            }
        }
    }

    return -1
}