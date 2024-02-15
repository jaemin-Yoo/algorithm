package boj.greedy

/**
 * 문제 번호: (1817)
 * 문제 이름: (짐 챙기는 숌)
 * 소요 시간(분): (11)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    if (n == 0) {
        println(0)
        return@with
    }
    val arr = readLine().split(" ").map { it.toInt() }
    var weight = 0
    var cnt = 0
    arr.forEach {
        weight += it
        if (weight > m) {
            weight = it
            cnt++
        } else if (weight == m) {
            weight = 0
            cnt++
        }
    }
    if (weight > 0) {
        cnt++
    }
    println(cnt)
    close()
}