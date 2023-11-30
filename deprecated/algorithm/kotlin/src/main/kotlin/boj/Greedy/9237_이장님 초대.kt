package boj.Greedy

import java.util.Collections.max

fun main() {
    val n = readln().toInt()
    val arr = readln().split(' ').map { it.toInt() }.sorted().toMutableList()

    for (i in arr.indices) {
        arr[i] -= i
    }
    println(max(arr) + arr.size + 1)
}