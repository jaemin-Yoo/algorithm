package com.jaemin.practicekotlin

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        val a = readln().toInt()
        list.add(a)
    }

    val cute = list.count { it == 1 }
    val notCute = list.count { it == 0 }
    val result = if (cute > notCute) {
        "Junhee is cute!"
    } else {
        "Junhee is not cute!"
    }
    println(result)
}