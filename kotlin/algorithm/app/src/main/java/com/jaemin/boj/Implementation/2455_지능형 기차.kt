package com.jaemin.practicekotlin.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections.max

fun getIntList() = readLine()!!.split(' ').map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var max = 0
    var count = 0
    repeat(4) {
        val (outT, inT) = getIntList()
        count -= outT
        count += inT
        max = if (max > count) max else count
    }
    println(max)
}