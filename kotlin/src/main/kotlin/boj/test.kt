package com.jaemin.practicekotlin

/**
 * 2589_보물섬
 */

import java.util.Queue
import java.util.LinkedList
import kotlin.math.max

var n = 0
var m = 0
val graph = mutableListOf<MutableList<Char>>()
lateinit var visited: Array<BooleanArray>
val dx = listOf(1, -1, 0, 0)
val dy = listOf(0, 0, 1, -1)
var mx = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (_n, _m) = readLine().split(" ").map{ it.toInt() }
    n = _n
    m = _m
    visited = Array(n) { BooleanArray(m) }
    repeat(n) {
        graph.add(readLine().toMutableList())
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'L') {
                bfs(Node(i, j, 0))
            }
        }
    }
    println(mx)

    close()
}

fun bfs(start: Node) {
    val q: Queue<Node> = LinkedList()
    q.add(start)
    visited[start.x][start.y] = false
    while (q.isNotEmpty()) {
        val (x, y, d) = q.poll()
        for (i in 0 until 4) {
            val a = x + dx[i]
            val b = y + dy[i]
            if (a in 0 until n
                && b in 0 until m
                && !visited[a][b]
                && graph[a][b] == 'L') {
                mx = max(mx, d + 1)
                q.add(Node(a, b, d + 1))
                visited[a][b] = true
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            visited[i][j] = false
        }
    }
}

data class Node(
    val x: Int,
    val y: Int,
    val dist: Int
)