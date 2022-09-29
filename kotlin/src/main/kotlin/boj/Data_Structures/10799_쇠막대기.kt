package boj.Data_Structures

import java.util.Stack

fun main() {
    val s = readln().toList()
    val stack = Stack<Char>()

    var idx = 0
    var result = 0
    while (idx < s.size) {
        if (s[idx] == '(' && s[idx + 1] == ')') {
            result += stack.count()
            idx += 2
        } else {
            if (s[idx] == '(') {
                stack.add(s[idx])
            } else {
                stack.pop()
                result += 1
            }
            idx += 1
        }
    }
    println(result)
}