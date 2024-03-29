package boj.greedy

/**
 * 문제 번호: (2872)
 * 문제 이름: (우리집엔 도서관이 있어)
 * 소요 시간(분): (12)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = HashMap<Int, Int>()
    repeat(n) {
        val book = readLine().toInt()
        map[book] = it
    }

    var cnt = 0
    for (book in n downTo 2) {
        if (map[book]!! < map[book - 1]!!) {
            map[book - 1] = -1
            cnt++
        }
    }
    println(cnt)
    close()
}