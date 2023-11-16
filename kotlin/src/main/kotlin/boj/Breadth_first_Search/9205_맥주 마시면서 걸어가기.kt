package boj.Breadth_first_Search.맥주마시면서걸어가기9205

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

private lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val convList = mutableListOf<Pair<Int, Int>>()
        visited = BooleanArray(n)
        val (startX, startY) = readLine().split(" ").map { it.toInt() }
        repeat(n) {
            val (storeX, storeY) = readLine().split(" ").map { it.toInt() }
            convList.add(storeX to storeY)
        }
        val (endX, endY) = readLine().split(" ").map { it.toInt() }

        val result = if (bfs(startX, startY, endX, endY, convList)) {
            "happy"
        } else {
            "sad"
        }
        println(result)
    }

    close()
}

private fun bfs(startX: Int, startY: Int, endX: Int, endY: Int, convList: MutableList<Pair<Int, Int>>): Boolean {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(startX to startY)

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()

        if (abs(x - endX) + abs(y - endY) <= 1000) {
            return true
        }

        for (i in 0 until convList.size) {
            val (a, b) = convList[i]
            if (abs(x - a) + abs(y - b) <= 1000 && !visited[i]) {
                q.add(a to b)
                visited[i] = true
            }
        }
    }

    return false
}