package com.jaemin.practicekotlin.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections.max

fun getIntList() = readLine()!!.split(' ').map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val result = ArrayList<Int>()
    var count = 0
    for (i in 0 until 4) {
        val (outT, inT) = getIntList()
        count -= outT
        count += inT
        result.add(count)
    }
    println(max(result))
}