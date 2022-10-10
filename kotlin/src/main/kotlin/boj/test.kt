package com.jaemin.practicekotlin

fun main() {
    val n = readln().toInt()
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        graph.add(readln().split(" ").map { it.toInt() })
    }
    var x = n * n - n
    var y = 1
    while (x !in 1..n) {
        x -= n * y
        y += 1
    }
    val v = graph[0].sorted()[x - 1]
    val i = graph[0].indexOf(v)
    println(graph[i][y])
}