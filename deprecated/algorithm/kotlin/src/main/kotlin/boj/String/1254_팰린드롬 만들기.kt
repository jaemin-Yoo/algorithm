package boj.String

import java.lang.Integer.max

fun main() {
    val s = readln()
    var result = 2 * s.length - 1
    for (i in s.length / 2 until s.length) {
        var back = s.substring(i, s.length)
        var front = s.substring(max(i - back.length, 0), i)

        if (front == back.reversed()) {
            result = s.length + i - back.length
            break
        }

        back = s.substring(i+1, s.length)
        front = s.substring(i - back.length, i)

        if (front == back.reversed()) {
            result = s.length + i - back.length
            break
        }
    }

    println(result)
}