package com.jaemin.practicekotlin

fun main() {
    val TEN_MILLION = 10000000
    readln()
    val cards = Array(TEN_MILLION * 2 + 1) { 0 }
    readln().split(" ").map {
        cards[TEN_MILLION + it.toInt()] = 1
    }
    readln()
    val result = readln().split(" ").map {
        cards[TEN_MILLION + it.toInt()]
    }
    println(result.joinToString(" "))
}