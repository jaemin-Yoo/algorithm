package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var arr = readLine().split(' ').map { it.toInt() }
    arr = arr.sorted()
    println(arr[(n-1)/2])
}