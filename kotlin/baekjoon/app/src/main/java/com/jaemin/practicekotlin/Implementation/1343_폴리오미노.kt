package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val s = readLine().replace("XXXX", "AAAA").replace("XX", "BB")
    println(if ('X' in s) -1 else s)
}