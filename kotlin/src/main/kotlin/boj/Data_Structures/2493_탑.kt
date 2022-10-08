package boj.Data_Structures

import java.util.*

fun main() {
    val n = readln().toInt()
    val topList = readln().split(" ").map { it.toInt() }
    val stack = Stack<Pair<Int, Int>>()
    stack.add(topList[0] to 0)

    val result = Array(n) { 0 }
    for (i in 1 until n) {
        var idx = 0
        while (stack.isNotEmpty()) {
            val (maxTop, maxIdx) = stack.peek()
            if (maxTop < topList[i]) {
                stack.pop()
            } else {
                idx = maxIdx + 1
                break
            }
        }
        stack.add(topList[i] to i)
        result[i] = idx
    }

    println(result.joinToString(" "))
}