package boj.Mathematics

import java.util.Collections.max

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val m = max(list)
    var i = 1
    val result = mutableSetOf<Int>()
    while(i <= m) {
        val cnt = list.count { it % i == 0 }
        if (cnt == n) {
            result.add(i)
        }
        i += 1
    }

    result.forEach {
        println(it)
    }
}