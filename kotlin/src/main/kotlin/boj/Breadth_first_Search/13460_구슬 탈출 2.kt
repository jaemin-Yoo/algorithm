package boj.Breadth_first_Search.구슬탈출2

import java.util.*

val graph = mutableListOf<MutableList<Char>>()
lateinit var visited: Array<Array<Array<Array<Int>>>>
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
fun main() {
    val (n ,m) = readln().split(" ").map { it.toInt() }
    var (rx, ry, bx, by) = listOf(-1, -1, -1, -1)
    visited = Array(n) { Array(m) { Array(n) { Array(m) { 0 } } } }
    repeat(n) { x ->
        val row = readln().toMutableList()
        val redY = row.indexOf('R')
        val blueY = row.indexOf('B')

        if (redY != -1) {
            rx = x
            ry = redY
        }

        if (blueY != -1) {
            bx = x
            by = blueY
        }

        graph.add(row)
    }
    visited[rx][ry][bx][by] = 1
    val result = bfs(Node(rx, ry, bx, by, 1))
    println(result)
}

fun bfs(node: Node): Int {
    val q: Queue<Node> = LinkedList()
    q.add(node)
    while (q.isNotEmpty()) {
        val (rx, ry, bx, by, depth) = q.poll()
        if (depth > 10) {
            return -1
        }
        for (i in 0 until 4) {
            var (ra, rb, rCnt) = move(rx, ry, dx[i], dy[i])
            var (ba, bb, bCnt) = move(bx, by, dx[i], dy[i])
            if (graph[ba][bb] != '#' && graph[ba][bb] != 'O') {
                if (graph[ra][rb] == 'O') { // RED가 빠져나갔을 때
                    return depth
                }

                if (ra == ba && rb == bb) { // RED, BLUE 위치가 같은 경우
                    if (rCnt > bCnt) {
                        ra -= dx[i]
                        rb -= dy[i]
                    } else {
                        ba -= dx[i]
                        bb -= dy[i]
                    }
                }

                if (visited[ra][rb][ba][bb] == 0) {
                    visited[ra][rb][ba][bb] = 1
                    q.add(Node(ra, rb, ba, bb, depth + 1))
                }
            }
        }
    }

    return -1
}

fun move(x: Int, y: Int, dx: Int, dy: Int): Triple<Int, Int, Int> {
    var cnt = 0
    var a = x
    var b = y
    while (graph[a+dx][b+dy] != '#' && graph[a][b] != 'O') {
        a += dx
        b += dy
        cnt += 1
    }
    return Triple(a, b, cnt)
}

data class Node(
    val rx: Int,
    val ry: Int,
    val bx: Int,
    val by: Int,
    val depth: Int
)