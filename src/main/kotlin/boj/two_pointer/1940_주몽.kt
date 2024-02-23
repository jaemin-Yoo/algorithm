package boj.two_pointer

/**
 * 문제 번호: (1940)
 * 문제 이름: (주몽)
 * 소요 시간(분): (3)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }
    var cnt = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (numbers[i] + numbers[j] == m) {
                cnt++
            }
        }
    }
    println(cnt)
    close()
}