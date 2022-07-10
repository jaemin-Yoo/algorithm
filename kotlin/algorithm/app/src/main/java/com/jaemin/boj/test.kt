package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()
    var result = ""
    for (i in n.indices) {
        var a = Integer.toBinaryString(n[i]-'0')
        if(a.length == 2 && i != 0) a = "0$a" else if (a.length == 1 && i != 0) a = "00$a"
        result += a
    }
    println(result)
}