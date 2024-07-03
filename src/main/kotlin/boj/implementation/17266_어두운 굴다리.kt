package boj.implementation

/**
 * 문제 번호: (17266)
 * 문제 이름: (어두운 굴다리)
 * 소요 시간(분): (12)
 */

import kotlin.math.ceil
import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val positions = br.readLine().split(' ').map { it.toInt() }
    var h = 0
    for (i in 1 until m) {
        h = max(h, ceil((positions[i] - positions[i - 1]) / 2.0).toInt())
    }
    h = max(h, positions[0] - 0)
    h = max(h, n - positions.last())
    println(h)
}