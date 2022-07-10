package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array(n+1) { 0 }

    arr[0] = 0
    arr[1] = 1
    for (i in 2 until n+1) {
        arr[i] = arr[i-1] + arr[i-2]
    }
    println(arr[n])
}