package boj.two_pointer

/**
 * 문제 번호: (14246)
 * 문제 이름: (K보다 큰 구간)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val k = br.readLine().toInt()

    var result = 0L
    for (i in 0 until n) {
        var sum = arr[i]
        if (sum > k) {
            result += n - i
            continue
        }

        for (j in i + 1 until n) {
            sum += arr[j]
            if (sum > k) {
                result += n - j
                break
            }
        }
    }
    println(result)
}