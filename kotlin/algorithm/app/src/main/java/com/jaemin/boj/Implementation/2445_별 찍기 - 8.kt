package com.jaemin.practicekotlin.Mathematics

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for (i in 1..n) println("*".repeat(i) + " ".repeat(2*n - (2*i)) + "*".repeat(i))
    for (i in n-1 downTo 1) println("*".repeat(i) + " ".repeat(2*n - (2*i)) + "*".repeat(i))
}