package boj.Breadth_first_Search.스타트링크5014

import java.util.LinkedList
import java.util.Queue

/**
 * 1. 입력 그래프 만들기
 * 2. 방문 그래프 만들기
 * 3. 출발점 정한 후 탐색 시작
 * 4. Queue 생성 (최소값 구하는 지 확인 후 Pair 여부)
 * 5. 출발점 방문 기록
 */
fun main() {
    val (f, s, g, u, d) = readln().split(" ").map { it.toInt() }
    val list = MutableList(f + 1) { false }
    val count = bfs(s, g, u, d, list)
    val result = if (count == -1) {
        "use the stairs"
    } else {
        count
    }
    println(result)
}

fun bfs(start: Int, end: Int, u: Int, d: Int, list: MutableList<Boolean>): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(start to 0)

    list[start] = true

    while (q.isNotEmpty()) {
        val (n, dist) = q.poll()

        if (n == end) {
            return dist
        }

        repeat(2) { i ->
            val a = when (i) {
                0 -> n + u
                1 -> n - d
                else -> -1
            }

            if (a in 1 until list.size && !list[a]) {
                list[a] = true
                q.add(a to dist + 1)
            }
        }
    }

    return -1
}