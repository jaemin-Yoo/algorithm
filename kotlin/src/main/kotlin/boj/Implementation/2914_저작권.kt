package com.jaemin.boj.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b) = readLine().split(' ').map { it.toInt() }
    println(a*(b-1)+1)
}