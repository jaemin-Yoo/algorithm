package boj.Breadth_first_Search.바닥장식1388

import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() } // 입력 받기

    // 입력 그래프 만들기
    val graph = mutableListOf<List<Char>>()
    repeat(n) {
        graph.add(readln().toList())
    }

    val visited = Array(n) { BooleanArray(m) } // 방문 그래프 만들기

    // 모든 정점 방문하기
    var cnt = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (bfs(i, j, graph, visited)) {
                cnt += 1
            }
        }
    }

    println(cnt)
}

fun bfs(startX: Int, startY: Int, graph: List<List<Char>>, visited: Array<BooleanArray>): Boolean {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(startX to startY)

    if (!visited[startX][startY]) {
        visited[startX][startY] = true
    } else {
        return false
    }

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        val (a, b) = if (graph[x][y] == '-') {
            x to y + 1
        } else {
            x + 1 to y
        }

        if (a in graph.indices && b in graph[0].indices && !visited[a][b] && graph[startX][startY] == graph[a][b]) {
            visited[a][b] = true
            q.add(a to b)
        }
    }

    return true
}