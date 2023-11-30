package boj.Data_Structures

import java.util.ArrayDeque

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toMutableList()
    val result = mutableListOf<Int>()
    val dq = ArrayDeque<Int>()

    for (i in 1..n) {
        dq.add(i)
    }

    while (dq.isNotEmpty()) {
        val v = dq.removeFirst()
        result.add(v)

        if (dq.isEmpty()) break

        val cnt = a[v - 1]
        if (cnt > 0) {
            repeat(cnt - 1) {
                val temp = dq.removeFirst()
                dq.addLast(temp)
            }
        } else {
            repeat(-cnt) {
                val temp = dq.removeLast()
                dq.addFirst(temp)
            }
        }
    }

    println(result.joinToString(" "))
}