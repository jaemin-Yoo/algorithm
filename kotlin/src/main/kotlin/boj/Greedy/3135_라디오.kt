package boj.Greedy

import kotlin.math.abs

fun main() {
    val (a, b) = readln().split(' ').map { it.toInt() }
    val n = readln().toInt()

    var minCnt = abs(a - b)
    repeat(n) {
        val c = readln().toInt()
        val cnt = abs(c - b)
        if (minCnt > cnt) {
            minCnt = cnt + 1
        }
    }
    println(minCnt)
}