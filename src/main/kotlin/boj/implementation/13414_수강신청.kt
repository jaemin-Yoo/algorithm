package boj.implementation

/**
 * 문제 번호: (13414)
 * 문제 이름: (수강신청)
 * 소요 시간(분): (16)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val (k, l) = br.readLine().split(' ').map { it.toInt() }
    val students = mutableListOf<String>()
    repeat(l) {
        val sID = br.readLine()
        students.add(sID)
    }

    val s = mutableSetOf<String>()
    for (i in l - 1 downTo 0) {
        s.add(students[i])
    }

    val result = s.toList().reversed()
    for (i in 0 until min(k, result.size)) {
        println(result[i])
    }
}