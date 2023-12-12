package boj.dynamic_programming

/**
 * 문제 번호: (9655)
 * 문제 이름: (돌 게임)
 * 소요 시간(분): (6)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val result = if (n % 2 == 0) {
        "CY"
    } else {
        "SK"
    }
    println(result)
    close()
}