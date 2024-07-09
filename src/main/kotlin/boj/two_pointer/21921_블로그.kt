package boj.two_pointer

/**
 * 문제 번호: (21921)
 * 문제 이름: (블로그)
 * 소요 시간(분): (17)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, x) = br.readLine().split(' ').map { it.toInt() }
    val arr = br.readLine().split(' ').map { it.toInt() }
    var cnt = 0
    for (i in 0 until x) {
        cnt += arr[i]
    }

    var start = 0
    var end = x
    var maxCount = cnt
    var periodCount = 1
    while (end < n) {
        cnt -= arr[start++]
        cnt += arr[end++]

        if (cnt > maxCount) {
            maxCount = cnt
            periodCount = 1
        } else if (cnt == maxCount) {
            periodCount++
        }
    }

    val result = if (maxCount == 0) {
        "SAD"
    } else {
        "$maxCount\n$periodCount"
    }
    print(result)
}