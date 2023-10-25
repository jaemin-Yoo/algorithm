package boj.Implementation.뱀3190

import java.util.LinkedList

private const val BLANK = 0
private const val APPLE = 1
private const val SNAKE = 2
private val dx = listOf(0, 1, 0, -1)
private val dy = listOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = Array(n + 1) { Array(n + 1) { BLANK } }

    val k = readLine().toInt()
    repeat(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        graph[x][y] = APPLE
    }

    val directionList = Array(10001) { "" }
    val l = readLine().toInt()
    repeat(l) {
        val (time, direction) = readLine().split(" ")
        directionList[time.toInt()] = direction
    }

    var headX = 1
    var headY = 1
    var tailX = 1
    var tailY = 1
    var d = 0
    var time = 0
    graph[1][1] = SNAKE
    val snakeList = LinkedList<Pair<Int, Int>>()
    snakeList.add(1 to 1)
    while (true) {
        when (directionList[time]) {
            "D" -> {
                d = (d + 1) % 4
            }
            "L" -> {
                d = (d + 3) % 4
            }
            else -> {}
        }
        headX += dx[d]
        headY += dy[d]

        if (!(headX in 1 until n + 1 && headY in 1 until n + 1)) {
            break
        }

        if (graph[headX][headY] != APPLE) {
            graph[tailX][tailY] = BLANK
        }

        when (graph[headX][headY]) {
            BLANK -> {
                val (x, y) = snakeList.pollFirst()
                tailX = x
                tailY = y
            }
            SNAKE -> break
            APPLE -> {}
        }

        graph[headX][headY] = SNAKE
        snakeList.add(headX to headY)

        time += 1
    }

    print(time + 1)

    close()
}