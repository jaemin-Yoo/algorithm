package com.jaemin.practicekotlin.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for (i in 0 until n) println(" ".repeat(i) + "*".repeat(2*n - 2*i - 1))
}