package boj.Greedy

import java.lang.Integer.min

fun main() {
    val (n, m) = readln().split(" ").map{ it.toInt() }
    val list = mutableListOf<Int>()
    repeat(m) {
        val p = readln().toInt()
        list.add(p)
    }
    list.sort()

    var maxP = 0
    var max = 0
    for (i in list.indices) {
        val v = list[i] * min(list.size - i, n)
        if (max < v) {
            max = v
            maxP = list[i]
        }
    }
    println("$maxP $max")
}