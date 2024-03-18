package boj.binary_search

/**
 * 문제 번호: (17266)
 * 문제 이름: (어두운 굴다리)
 * 소요 시간(분): (x)
 */

import kotlin.math.max
import kotlin.math.roundToInt

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val position = readLine().split(" ").map { it.toInt() }
    var height = max(position[0], n - position.last())
    for (i in 0 until m - 1) {
        height = max(height, ((position[i + 1] - position[i]) / 2.0).roundToInt())
    }
    println(height)
    close()
}