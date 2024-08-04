package boj.two_pointer

/**
 * 문제 번호: (2018)
 * 문제 이름: (수들의 합 5)
 * 소요 시간(분): (5)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()

    var start = 1
    var end = 1
    var s = 1
    var cnt = 0
    while (end <= n) {
        if (s < n) {
            end++
            s += end
        } else if (s > n) {
            s -= start
            start++
        } else {
            cnt++
            end++
            s += end
        }
    }
    print(cnt)
}