package com.jaemin.practicekotlin.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    for(i in 1..n) println("*".repeat(i))
    for(i in n-1 downTo 1) println("*".repeat(i))
}