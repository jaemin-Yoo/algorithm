package boj.dynamic_programming

/**
 * 문제 번호: (2096)
 * 문제 이름: (내려가기)
 * 소요 시간(분): (12)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val (initA, initB, initC) = readLine().split(" ").map { it.toInt() }
    val minDp = Array(n) { Triple(initA, initB, initC) }
    val maxDp = Array(n) { Triple(initA, initB, initC) }
    for (i in 1 until n) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        minDp[i] = Triple(
            a + minOf(minDp[i - 1].first, minDp[i - 1].second),
            b + minOf(minDp[i - 1].first, minDp[i - 1].second, minDp[i - 1].third),
            c + minOf(minDp[i - 1].second, minDp[i - 1].third)
        )
        maxDp[i] = Triple(
            a + maxOf(maxDp[i - 1].first, maxDp[i - 1].second),
            b + maxOf(maxDp[i - 1].first, maxDp[i - 1].second, maxDp[i - 1].third),
            c + maxOf(maxDp[i - 1].second, maxDp[i - 1].third)
        )
    }
    val mn = minOf(minDp[n - 1].first, minDp[n - 1].second, minDp[n - 1].third)
    val mx = maxOf(maxDp[n - 1].first, maxDp[n - 1].second, maxDp[n - 1].third)
    println("$mx $mn")
    close()
}