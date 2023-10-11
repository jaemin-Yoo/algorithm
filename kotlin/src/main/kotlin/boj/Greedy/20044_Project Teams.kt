package boj.Greedy

import java.lang.Integer.min

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    var result = Int.MAX_VALUE
    for (i in 0 until n) {
        result = min(result, list[i] + list[n * 2 - i - 1])
    }
    println(result)
}