package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine()
    var result = ""
    for (i in n.length - 1 downTo 0) {
        var v = n[i].toString().toInt()
        var temp = ""
        while(v >= 1) {
            if (v == 1) {
                temp = "1$temp"
                break
            }

            temp = (v % 2).toString() + temp
            v /= 2
        }
        temp = temp.padStart(3, '0')
        result = temp + result
    }

    for (i in result.indices) {
        if (result[i] == '1'){
            result = result.substring(i until result.length)
            break
        }
    }
    println(result)
}