package com.jaemin.practicekotlin

fun main() {
    val t: Int? = null
    val a = t ?: t.let {
        println(it)
        3
    }
    println(a)
}