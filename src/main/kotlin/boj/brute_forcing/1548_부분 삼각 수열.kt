package boj.brute_forcing

/**
 * 문제 번호: (1548)
 * 문제 이름: (부분 삼각 수열)
 * 소요 시간(분): (30)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map{ it.toInt() }.toIntArray()
    arr.sort()

    val result = if (n == 1) {
        1
    } else {
        solve(n, arr)
    }
    println(result)

    close()
}

private fun solve(n: Int, arr: IntArray): Int {
    var maxLen = 2
    for (i in n downTo 2) {
        for (j in 0 until i - 2) {
            if (arr[j] + arr[j + 1] > arr[i - 1]) {
                if (maxLen < i - j) {
                    maxLen = i - j
                }
            }
        }
    }
    return maxLen
}