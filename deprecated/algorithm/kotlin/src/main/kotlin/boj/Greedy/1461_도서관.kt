package boj.Greedy.도서관1416

import kotlin.math.abs

var result = 0
var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, _m) = readLine().split(" ").map { it.toInt() }
    m = _m
    val list = readLine().split(" ").map { it.toInt() }.toMutableList()
    list.add(0)
    list.sort()

    val mx = list.maxOf { it }
    val mn = list.minOf { it }

    if (abs(mx) > abs(mn)) {
        val zeroPos = list.indexOf(0)
        solve(zeroPos, list)
    } else {
        list.reverse()
        val zeroPos = list.indexOf(0)
        solve(zeroPos, list)
    }
    println(result)

    close()
}

fun solve(zeroPos: Int, list: MutableList<Int>) {
    for (i in 0 until zeroPos step m) {
        result += abs(list[i]) * 2
    }

    result += abs(list[list.lastIndex])
    for (i in list.lastIndex - m downTo zeroPos + 1 step m) {
        result += abs(list[i]) * 2
    }
}