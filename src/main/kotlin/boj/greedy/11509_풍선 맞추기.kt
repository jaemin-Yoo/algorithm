package boj.greedy

/**
 * 문제 번호: (11509)
 * 문제 이름: (풍선 맞추기)
 * 소요 시간(분): (18)
 */

private const val MAX_SIZE = 1_000_000

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val h = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(MAX_SIZE + 1)

    var cnt = 0
    for (i in 0 until n) {
        val x = h[i]
        if (arr[x] == 0) {
            arr[x - 1] += 1
            cnt++
        } else {
            arr[x - 1] += 1
            arr[x] -= 1
        }
    }
    println(cnt)

    close()
}