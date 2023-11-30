package boj.Greedy

import java.util.*

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val stack = Stack<Int>()
        stack.add(0)
        stack.add(1)
        var i = 2
        while (true) {
            val v = stack[i - 1] + stack[i - 2]
            if (v > n) {
                break
            }
            stack.add(v)
            i += 1
        }

        var k = n
        val result = mutableListOf<Int>()
        while (stack.isNotEmpty()) {
            val v = stack.pop()
            if (v <= k) {
                k -= v
                result.add(v)
            }

            if (k == 0) {
                break
            }
        }

        result.sort()
        println(result.joinToString(" "))
    }
}

/*

0 1 1 2 3 5 8 13 21 34 55 89 144

 */