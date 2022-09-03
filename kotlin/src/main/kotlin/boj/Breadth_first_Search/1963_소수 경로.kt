package boj.Breadth_first_Search

import java.util.LinkedList
import java.util.Queue
import kotlin.math.sqrt

lateinit var visited: MutableList<String>
fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (start, end) = readln().split(' ').map { it.toCharArray() }
        visited = mutableListOf()
        println(bfs(start, end))
    }
}

fun bfs(start: CharArray, end: CharArray): String {
    val q: Queue<Pair<CharArray, Int>> = LinkedList()
    q.add(start to 0)
    visited.add(start.joinToString(""))
    while (q.isNotEmpty()) {
        val (n, depth) = q.poll()
        if (n.contentEquals(end)) return depth.toString()

        for (i in 0 until 4) {
            for (j in 0..9) {
                val strN = n.copyOf()
                strN[i] = j.digitToChar()

                val num = strN.joinToString("").toInt()
                if (isPrimeNumber(num)
                    && strN.joinToString("") !in visited
                    && num >= 1000) {
                    q.add(strN to depth + 1)
                    visited.add(strN.joinToString(""))
                }
            }
        }
    }

    return "Impossible"
}

fun isPrimeNumber(x: Int): Boolean {
    for (i in 2 until sqrt(x.toDouble()).toInt() + 1) {
        if (x % i == 0) return false
    }

    return true
}