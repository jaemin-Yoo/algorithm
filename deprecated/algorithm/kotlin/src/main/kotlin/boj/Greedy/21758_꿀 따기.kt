package boj.Greedy

import java.lang.Integer.max

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val s = MutableList(n) { 0 }
    s[0] = list[0]
    for (i in 1 until n) {
       s[i] = list[i] + s[i - 1]
    }

    // 벌 벌 꿀통
    val sum1 = s[n - 1] - s[0]
    var max1 = 0
    for (i in 1 until n - 1) {
        max1 = max(max1, sum1 + s[n - 1] - s[i] - list[i])
    }

    // 벌 꿀통 벌
    var max2 = 0
    for (i in 1 until n - 1) {
        max2 = max(max2, s[i] - s[0] + s[n - 2] - s[i - 1])
    }

    // 꿀통 벌 벌
    var max3 = 0
    for (i in 1 until n - 1) {
        max3 = max(max3, s[n - 2] + s[i - 1] - list[i])
    }

    val result = listOf(max1, max2, max3).maxOf { it }
    println(result)
}