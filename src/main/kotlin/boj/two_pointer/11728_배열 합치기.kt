package boj.two_pointer

/**
 * 문제 번호: (11728)
 * 문제 이름: (배열 합치기)
 * 소요 시간(분): (10)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }
    val b = readLine().split(" ").map { it.toInt() }
    var aIdx = 0
    var bIdx = 0
    val result = IntArray(n + m)
    for (i in 0 until n + m) {
        result[i] = if (aIdx >= n || (bIdx < m && a[aIdx] > b[bIdx])) {
            b[bIdx++]
        } else {
            a[aIdx++]
        }
    }
    println(result.joinToString(" "))
    close()
}