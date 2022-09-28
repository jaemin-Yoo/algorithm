package boj.Breadth_first_Search

import java.util.LinkedList
import java.util.Queue

val graph = mutableListOf<MutableList<Char>>()
val visited by lazy { Array(n) { Array(m) { 0 } } }
val dx = listOf(-1, 1, 0, 0)
val dy = listOf(0, 0, -1, 1)
var n = 0
var m = 0
fun main() {
    val (_n, _m) = readln().split(" ").map { it.toInt() }
    n = _n
    m = _m
    var redX = 0
    var redY = 0
    var blueX = 0
    var blueY = 0
    repeat(n) {
        val row = readln().toMutableList()
        graph.add(row)
        val idx = row.indexOf('R')
        if (idx != -1) {
            redX = it
            redY = idx
        }

        val blueIdx = row.indexOf('B')
        if (blueIdx != -1) {
            blueX = it
            blueY = blueIdx
        }
    }
    val dist = bfs(Triple(redX, redY, 1), BluePoint(blueX, blueY, blueX, blueY))
    val result = if (dist > 10) {
        -1
    } else {
        dist
    }
    println(result)
}

fun bfs(redStart: Triple<Int, Int, Int>, blueStart: BluePoint): Int {
    val redQ: Queue<Triple<Int, Int, Int>> = LinkedList()
    val blueQ: Queue<BluePoint> = LinkedList()
    redQ.add(redStart)
    blueQ.add(blueStart)
    visited[redStart.first][redStart.second] = 1
    while (redQ.isNotEmpty()) {
        val (x, y, dist) = redQ.poll()
        val (bx, by, prevX, prevY) = blueQ.poll()

        for (i in 0 until 4) {
            val redDes = moveRed(x, y, i)
            val blueDes = moveBlue(bx, by, i)
            var redPoint = Triple(redDes.first, redDes.second, dist + 1)
            var bluePoint = BluePoint(blueDes.first, blueDes.second, bx, by)

            if (blueDes == Triple(0, 0, 0)) {
                continue
            }

            if (redDes == blueDes) {
                if (redDes.third > blueDes.third) {
                    val a = redDes.first - dx[i]
                    val b = redDes.second - dy[i]
                    redPoint = Triple(a, b, dist + 1)
                    visited[a][b] = 1
                } else {
                    val a = redDes.first
                    val b = redDes.second
                    bluePoint = BluePoint(blueDes.first - dx[i], blueDes.second - dy[i], bx, by)
                    visited[a][b] = 1
                }
            }

            println("$redDes $blueDes $bluePoint")

            if (redDes == Triple(0, 0, 0)) {
                return dist
            }

            redQ.add(redPoint)
            blueQ.add(bluePoint)
        }
    }

    return -1
}

fun moveRed(x: Int, y: Int, i: Int): Triple<Int, Int, Int> {
    var a = x + dx[i]
    var b = y + dy[i]
    var cnt = 0
    var des = Triple(x, y, cnt)
    while (true) {
        cnt += 1
        if ((graph[a][b] == '.' || graph[a][b] == 'B') && visited[a][b] == 0) {
            des = Triple(a, b, cnt)
            a += dx[i]
            b += dy[i]
        } else if (graph[a][b] == 'O') {
            return Triple(0, 0, 0)
        } else {
            return des
        }
    }
}

fun moveBlue(x: Int, y: Int, i: Int): Triple<Int, Int, Int> {
    var a = x + dx[i]
    var b = y + dy[i]
    var cnt = 0
    var des = Triple(x, y, cnt)
    while (true) {
        cnt += 1
        if (graph[a][b] == '.' || graph[a][b] == 'R' || graph[a][b] == 'B') {
            des = Triple(a, b, cnt)
            a += dx[i]
            b += dy[i]
        } else if (graph[a][b] == 'O') {
            return Triple(0, 0, 0)
        } else {
            return des
        }
    }
}

data class BluePoint(
    val curX: Int,
    val curY: Int,
    val prevX: Int,
    val prevY: Int
)