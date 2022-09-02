package boj.Breadth_first_Search

import kotlin.math.sqrt

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val (start, end) = readln().split(' ').map { it.toCharArray() }
    }
}

fun isPrimeNumber(x: Int): Boolean {
    for (i in 2 until sqrt(x.toDouble()).toInt() + 1) {
        if (x % i == 0) return false
    }

    return true
}