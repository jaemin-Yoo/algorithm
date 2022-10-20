package boj.Implementation

import java.util.Collections.min
import java.util.Collections.max

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }
        println("${min(list)} ${max(list)}")
    }
}