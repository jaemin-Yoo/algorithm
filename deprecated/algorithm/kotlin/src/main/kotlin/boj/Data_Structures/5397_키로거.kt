package boj.Depth_first_Search

import java.util.LinkedList
import kotlin.math.max
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val s = readln()
        val result = LinkedList<Char>()
        var cursorIdx = 0
        s.forEach { c ->
            when (c) {
                '<' -> cursorIdx = max(cursorIdx - 1, 0)
                '>' -> cursorIdx = min(cursorIdx + 1, result.size)
                '-' -> {
                    if (cursorIdx != 0) {
                        result.removeAt(cursorIdx - 1)
                        cursorIdx -= 1
                    }
                }
                else -> {
                    result.add(cursorIdx, c)
                    cursorIdx += 1
                }
            }
        }
        println(result.joinToString(""))
    }
}