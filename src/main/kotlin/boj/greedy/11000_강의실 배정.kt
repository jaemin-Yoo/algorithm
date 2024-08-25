package boj.greedy

/**
 * 문제 번호: (11000)
 * 문제 이름: (강의실 배정)
 * 소요 시간(분): (x)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (s, t) = br.readLine().split(' ').map { it.toInt() }
        arr.add(s to 0)
        arr.add(t to 1)
    }
    arr.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

    var cnt = 0
    var result = 0
    arr.forEach { (_, state) ->
        if (state == 0) {
            cnt++
        } else {
            cnt--
        }
        result = max(result, cnt)
    }
    print(result)
}