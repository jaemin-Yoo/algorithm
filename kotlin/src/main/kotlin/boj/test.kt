package com.jaemin.practicekotlin

import java.util.*

val dx = listOf(-1, 1, 0, 0, -1, 1, -1, 1)
val dy = listOf(0, 0, -1, 1, -1, 1, 1, -1)
var n = 0
var cnt = 0
fun main() {
    n = readln().toInt()
    val visited = MutableList(n) { MutableList(3) { 0 } }
    bfs(Point(0, 0, 1, visited))
    println(cnt % 1000000000)
}

fun bfs(start: Point) {
    val q: Queue<Point> = LinkedList()
    start.visited[start.x][start.y] = 1
    q.add(start)
    while (q.isNotEmpty()) {
        val (x, y, c, v) = q.poll()
        if (x == n - 1 && y == 2) {
            if (c == n * 3) cnt += 1
        }
        for (i in 0 until 8) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n
                && b in 0 until 3
                && v[a][b] == 0) {
                val temp = v.map {
                    it.toMutableList()
                }.toMutableList()
                temp[a][b] = 1

                q.add(Point(a, b, c + 1, temp))
            }
        }
    }
}

data class Point(
    val x: Int,
    val y: Int,
    val cnt: Int,
    val visited: MutableList<MutableList<Int>>
)