package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for (i in 0 until n){
        val arr = readLine().split(' ').toTypedArray()
        for (i in arr.indices) {
            arr[i] = arr[i].reversed()
        }
        println(arr.joinToString(" "))
    }
}