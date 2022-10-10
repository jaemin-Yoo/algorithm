package boj.Data_Structures

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val n = readln().toInt()
    val s = readln()
    val stack = Stack<Double>()
    val map = HashMap<Char, Double>()
    for (i in 0 until n) {
        map[(65 + i).toChar()] = readln().toDouble()
    }

    s.forEach {
        if (it.isLetter()) {
            stack.add(map[it])
        } else {
            val b = stack.pop()
            val a = stack.pop()
            when (it) {
                '+' -> stack.add(a + b)
                '-' -> stack.add(a - b)
                '*' -> stack.add(a * b)
                '/' -> stack.add(a / b)
            }
        }
    }

    val result = stack.pop()
    println(String.format("%.2f", result))
}