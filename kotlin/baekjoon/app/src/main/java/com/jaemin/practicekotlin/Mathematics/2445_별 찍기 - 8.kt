package com.jaemin.practicekotlin.Mathematics

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    for (idx in 0 until 2*n) {
        var i = idx
        if (i >= n) {
            i = 2 * (n-1) - idx
        }

        val row = "*".repeat(i+1) + " ".repeat(n - (i+1)) + " ".repeat(n-(i+1)) + "*".repeat(i+1)
        println(row)
    }
}