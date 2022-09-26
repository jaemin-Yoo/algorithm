package com.jaemin.practicekotlin

import java.util.LinkedList
import java.util.Queue

fun main() {
    println(isExpTwo(4))
    println(isExpTwo(16))
    println(isExpTwo(2))

}

fun isExpTwo(n: Int) = n and (n - 1) == 0