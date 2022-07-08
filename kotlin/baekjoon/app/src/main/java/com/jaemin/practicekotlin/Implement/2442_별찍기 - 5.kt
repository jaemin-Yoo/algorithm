package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    for (i in 0 until n) {
        for (j in 0 until n-i-1) {
            print(" ")
        }

        for (k in 0 until 2*i+1) {
            print("*")
        }

        println()
    }
}