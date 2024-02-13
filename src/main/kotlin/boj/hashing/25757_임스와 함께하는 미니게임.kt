package boj.hashing

/**
 * 문제 번호: (25757)
 * 문제 이름: (임스와 함께하는 미니게임)
 * 소요 시간(분): (12)
 */

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val (n, y) = st.nextToken().toInt() to st.nextToken()
    val maxNum = when(y) {
        "Y" -> 2
        "F" -> 3
        "O" -> 4
        else -> throw IllegalStateException()
    }
    val players = mutableSetOf<String>()
    repeat(n) {
        val p = readLine()
        players.add(p)
    }
    println(players.size / (maxNum - 1))

    close()
}