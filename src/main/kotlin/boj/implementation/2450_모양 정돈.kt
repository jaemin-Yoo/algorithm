package boj.implementation

/**
 * 문제 번호: (2450)
 * 문제 이름: (모양 정돈)
 * 소요 시간(분): (x)
 */

import kotlin.math.min
import kotlin.math.max

private const val TRIANGLE = 1
private const val SQUARE = 2
private const val CIRCLE = 3

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val tCount = arr.count { it == TRIANGLE }
    val sCount = arr.count { it == SQUARE }
    val cCount = arr.count { it == CIRCLE }
    val combinations = listOf(
        listOf(TRIANGLE to tCount, SQUARE to sCount, CIRCLE to cCount),
        listOf(TRIANGLE to tCount, CIRCLE to cCount, SQUARE to sCount),
        listOf(SQUARE to sCount, CIRCLE to cCount, TRIANGLE to tCount),
        listOf(SQUARE to sCount, TRIANGLE to tCount, CIRCLE to cCount),
        listOf(CIRCLE to cCount, TRIANGLE to tCount, SQUARE to sCount),
        listOf(CIRCLE to cCount, SQUARE to sCount, TRIANGLE to tCount)
    )
    var minCnt = Int.MAX_VALUE
    for (comb in combinations) {
        val (g1, g1Count) = comb[0]
        val (g2, g2Count) = comb[1]
        val (g3, g3Count) = comb[2]

        var cnt = 0
        cnt += arr.subList(0, g1Count).count { it != g1 }
        cnt += max(arr.subList(g1Count, g1Count + g2Count).count { it == g3 }, arr.subList(g1Count + g2Count, g1Count + g2Count + g3Count).count { it == g2 })
        minCnt = min(minCnt, cnt)
    }
    println(minCnt)

    close()
}

/*

1 3 3 2 1 1 3 2
3 3 3 2 2 1 1 1

1. 조합 만들기 (1, 2, 3) .. (1 to 3, 2 to 2, 3 to 3)
2.

 */