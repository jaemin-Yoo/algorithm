package boj.priority_queue

/**
 * 문제 번호: (1748)
 * 문제 이름: (수 이어 쓰기 1)
 * 소요 시간(분): (8)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var cnt = 0
    for (i in 1 until n + 1) {
        var q = i / 10
        while (q >= 0) {
            cnt++
            if (q == 0) break
            q /= 10
        }
    }
    println(cnt)
    close()
}