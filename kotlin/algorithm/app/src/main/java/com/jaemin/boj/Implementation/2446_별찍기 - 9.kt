package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for (i in 1..n) {
        println(" ".repeat(i-1) + "*".repeat(2*n - (2*i-1)))
    }
    for (i in 1 until n) {
        println(" ".repeat(n-i-1) + "*".repeat(2*i+1))
    }
}