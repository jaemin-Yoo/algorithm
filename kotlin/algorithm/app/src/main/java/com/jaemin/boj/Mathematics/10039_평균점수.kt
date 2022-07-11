package com.jaemin.boj.Mathematics

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var sum = 0
    repeat(5) {
        var n =  readLine().toInt()
        n = if (n > 40) n else 40
        sum += n
    }
    println(sum / 5)
}