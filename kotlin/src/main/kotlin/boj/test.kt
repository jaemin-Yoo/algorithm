package com.jaemin.practicekotlin

fun main() {

    val list = ArrayList<Int>()
    val a = MutableList(5) { 1 }
    val b = List(7) { true }
    val c = Array(6) { 1 }

    println(listOf(1, 2, 3) == mutableListOf(1, 2, 4))
}