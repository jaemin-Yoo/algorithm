package boj.implementation

/**
 * 문제 번호: (2331)
 * 문제 이름: (반복수열)
 * 소요 시간(분): (9)
 */

import kotlin.math.pow

fun main() = with(System.`in`.bufferedReader()){
    val (a, p) = readLine().split(" ").map { it.toInt() }
    val d = mutableListOf(a.toString())
    val result: Int
    while (true) {
        val s = d.last()
        var sum = 0
        s.forEach { c ->
            sum += (c.toString().toDouble().pow(p)).toInt()
        }

        val ss = sum.toString()
        if (!d.contains(ss)) {
            d.add(ss)
        } else {
            result = d.indexOf(ss)
            break
        }
    }
    println(result)
    close()
}