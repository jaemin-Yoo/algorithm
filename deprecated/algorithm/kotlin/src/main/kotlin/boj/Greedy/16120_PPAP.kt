package boj.Greedy

import java.util.Stack

fun main() {
    val s = readln()
    val result = if (isPPAP(s)) {
        "PPAP"
    } else {
        "NP"
    }
    println(result)
}

private fun isPPAP(s: String): Boolean {
    if (s == "P") {
        return true
    }

    if (s.length < 4) {
        return false
    }

    val stack = Stack<Char>()
    for (i in s.indices) {
        if (s[i] == 'P') {
            stack.add('P')
        } else if (stack.size >= 2 && s[i] == 'A' && i < s.lastIndex && s[i + 1] == 'P') {
            stack.pop()
            stack.pop()
        } else {
            return false
        }
    }

    return stack.size == 1 && stack.peek() == 'P'
}