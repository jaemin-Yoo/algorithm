package boj.Data_Structures.괄호_제거2800

import java.util.*

val cbnList = mutableListOf<List<Int>>()
fun main() {
    val s = readln()
    val count = s.count { it == '(' }
    for (i in 1..count) {
        combine(mutableListOf(), i, count, 1)
    }

    val stack = Stack<Int>()
    val closeList = mutableListOf<Int>()
    var i = 1
    s.forEach {
        if (it == '(') {
            stack.add(i)
            i += 1
        } else if (it == ')') {
            val v = stack.pop()
            closeList.add(v)
        }
    }

    val result = mutableListOf<String>()
    for (arr in cbnList) {
        var openCnt = 1
        var closeIdx = 0
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
                    val v = if (closeList[closeIdx] !in arr) {
                        it
                    } else {
                        ""
                    }
                    closeIdx += 1
                    v
                }
                else -> it
            }
        }.joinToString("")
        result.add(exp)
    }

    val res = result.sorted().distinct()
    res.forEach {
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