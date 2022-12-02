package com.jaemin.practicekotlin

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sortedDescending()
    println(list[b - 1])
}