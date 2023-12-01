package boj.binary_search

/**
 * 문제 번호: (2110)
 * 문제 이름: (공유기 설치)
 * 소요 시간(분): (x)
 */

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    repeat(n) {
        val x = readLine().toInt()
        list.add(x)
    }
    list.sort()

    var mnDist = Int.MAX_VALUE
    val mxDist = list.last() - list.first()
    for (i in 0 until list.size - 1) {
        mnDist = min(mnDist, list[i + 1] - list[i])
    }

    val result = binarySearch(mnDist, mxDist, c, list)
    println(result)

    close()
}

private fun binarySearch(start: Int, end: Int, c: Int, list: List<Int>): Int {
    if (c == 2) return end

    var left = start
    var right = end
    var answer = end
    while (left <= right) {
        val mid = (right + left) / 2
        var prevX = list.first()
        var cnt = 1
        for (x in list) {
            val dist = x - prevX
            if (dist >= mid) {
                prevX = x
                cnt += 1
            }
        }

        if (cnt >= c) {
            left = mid + 1
            answer = mid
        } else {
            right = mid - 1
        }
    }

    return answer
}