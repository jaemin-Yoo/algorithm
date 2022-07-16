package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val s = readLine()
    for (c in s) {
        when (c.code) {
            in 65..90 -> {
                val code = c.code + 13
                if (code > 90) {
                    print((code - 90 + 65 - 1).toChar())
                } else {
                    print(code.toChar())
                }
            }
            in 97..122 -> {
                val code = c.code + 13
                if (code > 122) {
                    print((code - 122 + 97 -1).toChar())
                } else {
                    print(code.toChar())
                }
            }
            else -> {
                print(c)
            }
        }
    }
}