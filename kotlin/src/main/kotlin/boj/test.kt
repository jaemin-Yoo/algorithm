package com.jaemin.practicekotlin

import kotlin.math.max

fun main() {
    var max = 0
    var result = 0
    repeat(10) {
        val (a, b) = readln().split(" ").map{ it.toInt() }
        result -= a
        result += b
        max = max(max, result)
    }
    println(max)
}