package boj.prefix_sum

/**
 * 문제 번호: (11659)
 * 문제 이름: (구간 합 구하기 4)
 * 소요 시간(분): (5)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val arr = br.readLine().split(' ').map { it.toInt() }
    val prefixSum = IntArray(n + 1)
    var s = 0
    for (i in 0 until n) {
        s += arr[i]
        prefixSum[i + 1] = s
    }
    repeat(m) {
        val (i, j) = br.readLine().split(' ').map { it.toInt() }
        println(prefixSum[j] - prefixSum[i - 1])
    }
}