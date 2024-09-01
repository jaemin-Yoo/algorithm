package boj.greedy

/**
 * 문제 번호: (2141)
 * 문제 이름: (우체국)
 * 소요 시간(분): (x)
 */

import kotlin.math.ceil

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val villages = mutableListOf<Pair<Int, Int>>()
    var total = 0L
    repeat(n) {
        val (v, count) = br.readLine().split(' ').map { it.toInt() }
        villages.add(v to count)
        total += count
    }
    villages.sortWith(compareBy { it.first })

    var temp = 0L
    for ((v, count) in villages) {
        temp += count
        if (temp >= ceil(total / 2.0)) {
            print(v)
            break
        }
    }
}