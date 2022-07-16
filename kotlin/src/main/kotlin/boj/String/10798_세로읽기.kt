package com.jaemin.boj.String

fun main() {
    val graph = arrayListOf<String>()
    var maxSize = 0

    repeat(5) {
        val s = readLine()!!
        graph.add(s)
        if(maxSize < s.length) maxSize = s.length
    }

    for(i in 0 until maxSize) {
        graph.forEach {
            if(it.length > i) print(it[i])
        }
    }
}