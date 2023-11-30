package boj.Greedy

import java.lang.Integer.max

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln()
        val b = readln()
        var wCount = 0
        var bCount = 0
        for (i in 0 until n) {
            if (a[i] != b[i]) {
                if (a[i] == 'W') {
                    wCount += 1
                } else {
                    bCount += 1
                }
            }
        }
        println(max(wCount, bCount))
    }
}