package boj.dynamic_programming

/**
 * 문제 번호: (14002)
 * 문제 이름: (가장 긴 증가하는 부분 수열 4)
 * 소요 시간(분): (0834 ~ 0853)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { 1 to -1 }
    for (i in 1 until n) {
        var maxLen = 1
        for (j in 0 until i) {
            if (list[i] > list[j] && maxLen < dp[j].first + 1) {
                maxLen = dp[j].first + 1
                dp[i] = maxLen to j
            }
        }
    }

    val mx = dp.maxOf { it.first }
    var idx = dp.indexOfFirst { it.first == mx }
    val result = IntArray(mx)
    var i = mx - 1
    while (idx != -1) {
        result[i] = list[idx]
        idx = dp[idx].second
        i--
    }
    println(mx)
    println(result.joinToString(" "))

    close()
}