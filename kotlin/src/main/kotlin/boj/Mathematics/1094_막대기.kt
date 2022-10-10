package boj.Mathematics

import java.util.Stack

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    stack.add(64)

    if (n == 64) {
        println(1)
    } else {
        while (true) {
            val v = stack.pop()
            stack.add(v / 2)
            val s = stack.sumOf { it }
            if (s == n) {
                println(stack.count())
                break
            }

            if (s < n) {
                stack.add(v / 2)
            }
        }
    }
}