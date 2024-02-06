package boj.binary_search

/**
 * 문제 번호: (2512)
 * 문제 이름: (예산)
 * 소요 시간(분): (14)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    var m = readLine().toInt()
    var x = m / n
    for (i in 0 until n) {
        if (x >= arr[n - 1]) {
            x = arr[n - 1]
            break
        }

        if (x > arr[i]) {
            m -= arr[i]
            x = m / (n - i - 1)
        }
    }
    println(x)
    close()
}