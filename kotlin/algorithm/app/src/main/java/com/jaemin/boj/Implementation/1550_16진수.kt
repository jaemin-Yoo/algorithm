package com.jaemin.boj.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine()
    println(Integer.parseInt(s, 16))
}