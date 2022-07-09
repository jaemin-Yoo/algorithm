package com.jaemin.practicekotlin.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (r1, s) = readLine().split(' ').map { it.toInt() }
    println(2*s - r1)
}