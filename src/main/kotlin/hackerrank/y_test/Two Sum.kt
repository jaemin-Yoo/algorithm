package hackerrank.y_test

/**
 * 문제: “11”, “123” 와 같은 두 문자열이 들어왔을 때 두 숫자의 합인 “134” 을 반환하도록 구현
 * 제약 사항: 문자열의 길이는 0 < n < 10^4, 문자열 및 정수 변환 내장 함수 사용 금지
 */

import kotlin.math.max

fun main() {
    println(getSumString("11", "123"))
    println(getSumString("8174", "64832"))
}

private fun getSumString(s1: String, s2: String): String {
    val n = max(s1.length, s2.length)
    val rs1 = s1.reversed()
    val rs2 = s2.reversed()
    var t = 0
    val result = mutableListOf<Char>()
    for (i in 0 until n + 1) {
        val x = if (i > rs1.lastIndex) {
            '0'
        } else {
            rs1[i]
        }
        val y = if (i > rs2.lastIndex) {
            '0'
        } else {
            rs2[i]
        }
        val a = x.convertToInt()
        val b = y.convertToInt()
        val sum = a + b + t
        val v = if (sum >= 10) {
            t = 1
            sum - 10
        } else {
            t = 0
            sum
        }
        result.add(v.convertToChar())
    }

    var last = result.last()
    while (last == '0') {
        result.removeLast()
        last = result.last()
    }

    return result.reversed().joinToString("")
}

private fun Char.convertToInt(): Int {
    val s = "0123456789"
    val map = HashMap<Char, Int>()
    for (i in s.indices) {
        val c = s[i]
        map[c] = i
    }
    return map[this]!!
}

private fun Int.convertToChar(): Char {
    val s = "0123456789"
    val map = HashMap<Int, Char>()
    for (i in s.indices) {
        val c = s[i]
        map[i] = c
    }
    return map[this]!!
}