package com.jaemin.practicekotlin.Mathematics

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    println(n-1 + n * (m-1))
}