package com.jaemin.practicekotlin

val cbnList = mutableListOf<List<Int>>()
fun main() {
    val s = readln()
    val count = s.count { it == '(' }
    for (i in 1..count) {
        combine(mutableListOf(), i, count, 1)
    }

    val result = mutableListOf<String>()
    for (arr in cbnList) {
        var openCnt = 1
        var closeCnt = count
        val exp = s.map {
            when (it) {
                '(' -> {
                    val v = if (openCnt !in arr) {
                        it
                    } else {
                        ""
                    }
                    openCnt += 1
                    v
                }
                ')' -> {
                    val v = if (closeCnt !in arr) {
                        it
                    } else {
                        ""
                    }
                    closeCnt -= 1
                    v
                }
                else -> it
            }
        }.joinToString("")
        result.add(exp)
    }

    result.sort()
    result.forEach {
        println(it)
    }
}

fun combine(arr: MutableList<Int>, n: Int, count: Int, start: Int) {
    if (arr.size == n) {
        cbnList.add(arr.toList())
        return
    }

    for (i in start..count) {
        if (i !in arr) {
            arr.add(i)
            combine(arr, n, count, i + 1)
            arr.removeLast()
        }
    }
}