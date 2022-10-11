package com.jaemin.practicekotlin

fun main() {
    val n = readln().toInt()
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        graph.add(readln().split(" ").map { it.toInt() })
    }
    val result = solve(n, graph)
    println(result)
}

fun solve(n: Int, graph: MutableList<List<Int>>): Int {
    if (n == 1) return graph[0][0]

    var x = n * n - n
    if (n % 2 == 0) {
        x += 1
    }
    var y = 0
    while (x !in 1..n) {
        y += 1
        x -= n * y
    }
    val v = graph[0].sorted()[x - 1]
    val i = graph[0].indexOf(v)
    return graph[n - y][i]
}