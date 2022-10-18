package boj.Data_Structures

import java.util.LinkedList
import java.util.Queue

lateinit var arr: List<Int>
fun main() {
    arr = readln().map { it - '0' }
    for (n in arr) {
        bfs(n)
    }
}

fun bfs(start: Int) {
    val q: Queue<Int> = LinkedList()
    q.add(start)
    while (q.isNotEmpty()) {
        val x = q.poll()

    }
}