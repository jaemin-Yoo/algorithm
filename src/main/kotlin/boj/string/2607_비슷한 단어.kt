package boj.string

/**
 * 문제 번호: (2607)
 * 문제 이름: (비슷한 단어)
 * 소요 시간(분): (x)
 */

import kotlin.math.abs

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val word = readLine().toMutableList()
    var cnt = 0
    repeat(n - 1) {
        val s = readLine().toMutableList()
        val wordSize = word.size
        val sSize = s.size
        if (abs(wordSize - sSize) > 1) return@repeat

        word.forEach { c ->
            s.remove(c)
        }

        if ((sSize > wordSize && s.size == 1) || (wordSize > sSize && s.isEmpty()) || (wordSize == sSize && s.size <= 1)) {
            cnt++
        }
    }
    println(cnt)

    close()
}