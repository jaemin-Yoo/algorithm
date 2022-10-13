package boj.Depth_first_Search

import java.util.Stack

fun main() {
    val n = readln().toInt()
    var cnt = 0
    repeat(n) {
        val stack = Stack<Char>()
        val s = readln()
        stack.add(s[0])
        for (i in 1 until s.length) {
            if (stack.isEmpty() || stack.peek() != s[i]) {
                stack.add(s[i])
            } else if (stack.peek() == s[i]) {
                stack.pop()
            }
        }

        if (stack.isEmpty()) cnt += 1
    }
    println(cnt)
}