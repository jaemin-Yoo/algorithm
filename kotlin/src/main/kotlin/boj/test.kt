package com.jaemin.practicekotlin

fun main() {
    val next = nextPermutation("12345")
    println(next)
}

fun nextPermutation(s: String): String? {
    val numList = s.map{ it- '0'}.toMutableList()

    var a = 0
    for (i in numList.lastIndex downTo 1) {
        if (numList[i] > numList[i - 1]) {
            a = i
            break
        }
    }
    if (a == 0) return null

    var b = 0
    for (j in numList.lastIndex downTo 1) {
        if (numList[j] > numList[a - 1]) {
            b = j
            break
        }
    }

    swap(a - 1, b, numList)
    b = numList.lastIndex
    while (a < b) {
        swap(a, b, numList)
        a += 1
        b -= 1
    }

    return numList.joinToString("")
}

fun swap(x: Int, y: Int, list: MutableList<Int>) {
    val temp = list[x]
    list[x] = list[y]
    list[y] = temp
}