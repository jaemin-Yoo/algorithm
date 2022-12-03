package com.jaemin.practicekotlin

fun main() {
    val col = listOf('a', 'e', 'i', 'o', 'u')
    do {
        val input = readln().lowercase()
        if (input == "#") {
            break
        } else {
            println(input.count { col.contains(it) })
        }
    } while (true)
}