package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var s = readLine()
    while (s != null){
        println(s)
        s = readLine()
    }
}