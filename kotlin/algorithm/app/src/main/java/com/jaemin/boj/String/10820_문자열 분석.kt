package com.jaemin.boj.String

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while(true) {
        val row = readLine() ?: break
        val count = IntArray(4)

        for (s in row) {
            when {
                s.isLowerCase() -> count[0]++
                s.isUpperCase() -> count[1]++
                s.isDigit() -> count[2]++
                s.isWhitespace() -> count[3]++
            }
        }
        println(count.joinToString(" "))
    }
}