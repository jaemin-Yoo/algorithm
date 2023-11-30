package boj.String

import java.lang.Integer.max

fun main() {
    repeat(3) {
        val s = readln()
        var prev = '0'
        var cnt = 1
        var result = 0
        s.forEach {
            if (prev == it) {
                cnt += 1
            } else {
                prev = it
                result = max(result, cnt)
                cnt = 1
            }
        }

        if (cnt != 1) result = max(result, cnt)

        println(result)
    }
}