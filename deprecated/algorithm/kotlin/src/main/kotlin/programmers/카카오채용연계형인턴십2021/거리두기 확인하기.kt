package programmers.카카오채용연계형인턴십2021.거리두기확인하기

// 54분

import java.util.Queue
import java.util.LinkedList

private const val MAX_DIST = 2

class Solution {

    private val n = 5
    private val dx = listOf(1, -1, 0, 0)
    private val dy = listOf(0, 0, 1, -1)

    fun solution(places: Array<Array<String>>): IntArray {
        val answer = IntArray(n) { 1 }
        for (k in 0 until n) {
            for (i in 0 until n) {
                var result = 1
                for (j in 0 until n) {
                    val visited = Array(n) { BooleanArray(n) }
                    if (places[k][i][j] == 'P') {
                        result = bfs(Position(i, j, 0), visited, places[k])
                        answer[k] = result

                        if (result == 0) break
                    }
                }

                if (result == 0) break
            }
        }

        return answer
    }

    private fun bfs(start: Position, visited: Array<BooleanArray>, graph: Array<String>): Int {
        val q: Queue<Position> = LinkedList()
        q.add(start)
        visited[start.x][start.y] = true

        while (q.isNotEmpty()) {
            val (x, y, dist) = q.poll()

            if (graph[x][y] == 'P' && dist != 0) {
                return 0
            }

            if (dist >= MAX_DIST) continue

            for (i in 0 until 4) {
                val a = x + dx[i]
                val b = y + dy[i]

                if (a in 0 until n && b in 0 until n && !visited[a][b] && graph[a][b] != 'X') {
                    visited[a][b] = true
                    q.add(Position(a, b, dist + 1))
                }
            }
        }

        return 1
    }

    data class Position(
        val x: Int,
        val y: Int,
        val dist: Int
    )
}