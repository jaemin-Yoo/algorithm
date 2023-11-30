package boj.Greedy

import java.util.Stack

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val a = readln().map { it.toString().toInt() }
    val stack = Stack<Int>()

    var cnt = k
    a.forEach {
        while (stack.isNotEmpty() && stack.peek() < it && cnt > 0) {
            stack.pop()
            cnt -= 1
        }
        stack.add(it)
    }

    while (cnt > 0) {
        stack.pop()
        cnt -= 1
    }
    println(stack.joinToString(""))
}