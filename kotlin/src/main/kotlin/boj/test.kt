package com.jaemin.practicekotlin

import kotlin.math.max
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }

    var result = 0
    for (i in 0 until n) {
        var cnt = 0
        for (j in i + 1 until n) {
            if (list[i] > list[j]) {
                cnt += 1
            } else {
                result = max(result, cnt)
                break
            }
        }
        result = max(result, cnt)
    }
    println(result)
}