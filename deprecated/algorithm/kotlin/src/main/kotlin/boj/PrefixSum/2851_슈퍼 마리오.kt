package boj.PrefixSum

import kotlin.math.abs

fun main() {
    var s = 0
    var result = 0
    var diff = 100
    for (i in 1 until 11) {
        val n = readln().toInt()
        s += n

        val d = abs(s - 100)
        if (diff >= d) {
            result = s
            diff = d
        }
    }
    println(result)
}