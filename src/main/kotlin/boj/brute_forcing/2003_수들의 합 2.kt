package boj.brute_forcing

/**
 * 문제 번호: (2003)
 * 문제 이름: (수들의 합 2)
 * 소요 시간(분): (13)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }
    var start = 0
    var end = 0
    var sum = a[0]
    var cnt = 0
    while (start < n && end < n) {
        if (sum < m) {
            if (end++ >= n - 1) break
            sum += a[end]
        } else if (sum > m) {
            sum -= a[start]
            if (start++ >= n - 1) break
        } else {
            cnt++
            if (end++ >= n - 1) break
            sum += a[end]
        }
    }
    println(cnt)
    close()
}