package boj.implementation

/**
 * 문제 번호: (1515)
 * 문제 이름: (수 이어 쓰기)
 * 소요 시간(분): (26)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val s = br.readLine()
    var n = 1
    var idx = 0
    while (idx < s.length) {
        for (c in n.toString()) {
            if (idx < s.length && s[idx] == c) {
                idx++
            }
        }
        n++
    }

    println(n - 1)
}