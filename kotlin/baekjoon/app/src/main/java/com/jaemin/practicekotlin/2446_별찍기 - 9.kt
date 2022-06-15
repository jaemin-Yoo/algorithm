package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    for (i in 0 until n) {
        for (j in 0 until i) {
            print(" ")
        }

        for (j in 0 until -2*i+2*n-1){
            print("*")
        }

        println()
    }

    for (i in 0 until n-1) {
        for (j in 0 until n-i-2) {
            print(" ")
        }

        for (j in 0 until 2*i+3){
            print("*")
        }

        println()
    }
}