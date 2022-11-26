package com.jaemin.practicekotlin

fun main() {
    val n = readln().toInt()
    val a = mutableListOf<Char>()
    val b = mutableListOf<Char>()
    for (i in 0 until n) {
        if (i % 2 == 0) {
            a.add('*')
            b.add(' ')
        } else {
            a.add(' ')
            b.add('*')
        }
    }

    repeat(n) {
        println(a.joinToString("").trimEnd())

        if (n != 1) {
            println(b.joinToString("").trimEnd())
        }
    }
}