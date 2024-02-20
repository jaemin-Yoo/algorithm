package boj.dynamic_programming

/**
 * 문제 번호: (9625)
 * 문제 이름: (BABBA)
 * 소요 시간(분): (7)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val arr = Array(k + 1) { 0 to 0 }
    arr[1] = 0 to 1
    for (i in 2..k) {
        val (a, b) = arr[i - 1]
        arr[i] = b to a + b
    }
    val (a, b) = arr[k]
    println("$a $b")
    close()
}