package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()
    var i = 0
    for (c in s) {
        when(i) {
            0 -> if (c=='U') i++
            1, 3 -> if (c=='C') i++
            2 -> if (c=='P') i++
        }
    }
    println("I ${if (i == 4) "love" else "hate"} UCPC")
}