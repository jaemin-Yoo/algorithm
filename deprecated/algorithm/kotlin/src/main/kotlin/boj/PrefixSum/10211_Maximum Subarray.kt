package boj.PrefixSum

import java.lang.Integer.max

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.toMutableList()
        for (i in 1 until n) {
            a[i] += max(0, a[i - 1])
        }

        println(a.maxOf { it })
    }
}