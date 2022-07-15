package com.jaemin.boj.String

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true) {
        val s = readLine() ?: break
        val arr = arrayListOf(0, 0, 0, 0)

        for (c in s) {
            when(c.code) {
                in 97..122 -> arr[0] += 1
                in 65..90 -> arr[1] += 1
                in 48..57 -> arr[2] += 1
                else -> arr[3] += 1
            }
        }
        println(arr.joinToString(" "))
    }
}