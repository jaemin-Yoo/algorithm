package boj.Greedy

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val arr = mutableListOf<Int>()
    repeat(n) {
        arr.add(readln().toInt())
    }
    arr.sort()

    var result = 0L
    for (i in 1..n) {
        result += abs(arr[i-1] - i)
    }
    println(result)
}