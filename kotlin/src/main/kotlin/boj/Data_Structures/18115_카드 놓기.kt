package boj.Data_Structures

import java.util.*

fun main() {
    val n = readln().toInt()
    val seq = readln().split(" ").map { it.toInt() }
    val dq = ArrayDeque<Int>()
    val result = Array(n) { 0 }
    repeat(n) {
        dq.add(it)
    }

    var idx = n
    seq.forEach { x ->
        val v = when (x) {
            1 -> dq.removeLast()
            2 -> {
                val a = dq.removeLast()
                val b = dq.removeLast()
                dq.add(a)
                b
            }
            else -> dq.removeFirst()
        }
        result[v] = idx
        idx -= 1
    }

    println(result.reversed().joinToString(" "))
}