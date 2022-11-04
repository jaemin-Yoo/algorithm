package com.jaemin.practicekotlin

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val arr = Array(a) { Array(b) { 0 } }
    solve(a, arr)
    solve(a, arr)
    arr.forEach {
        println(it.joinToString(" "))
    }
}

fun solve(a: Int, arr: Array<Array<Int>>) {
    repeat(a) { i ->
        val list = readln().split(" ").map { it.toInt() }
        list.forEachIndexed { j, n ->
            arr[i][j] += n
        }
    }
}