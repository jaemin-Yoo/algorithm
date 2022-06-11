package com.jaemin.practicekotlin

import java.io.BufferedReader
import java.io.InputStreamReader

val date = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
val week = arrayOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (m, d) = readLine().split(' ').map { it.toInt() }

    var days = 0
    for (i in 1 until m){
        days += date[i]
    }
    days += d - 1
    println(week[days%7])
}