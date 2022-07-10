package com.jaemin.practicekotlin.Mathematics

import java.io.BufferedReader
import java.io.InputStreamReader

fun getIntList() = readLine()!!.split(' ').map { it.toInt() }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a, b) = getIntList()
    println(gcd(a, b))
    println(lcm(a, b))
}

fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while(y > 0) {
        val mod = x % y
        x = y
        y = mod
    }

    return x
}

fun lcm(a: Int, b: Int): Int = a * b / gcd(a, b)