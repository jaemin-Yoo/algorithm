package boj.Data_Structures.문자열폭발9935

import kotlin.math.max
import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val boom = readLine()

    val stack = Stack<Char>()
    s.forEach {
        stack.add(it)
        if (it == boom.last()) {
            val a = stack.slice(max(0, stack.size - boom.length) until stack.size).joinToString("")
            if (a == boom) {
                repeat(boom.length) {
                    stack.pop()
                }
            }
        }
    }
    val result = if (stack.isNotEmpty()) {
        stack.joinToString("")
    } else {
        "FRULA"
    }
    println(result)
    close()
}