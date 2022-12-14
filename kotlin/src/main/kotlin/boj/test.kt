package com.jaemin.practicekotlin

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toLong() }
    println(abs(n - m))
}
