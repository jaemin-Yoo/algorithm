package boj.hashing

/**
 * 문제 번호: (13423)
 * 문제 이름: (Three Dots)
 * 소요 시간(분): (36)
 */

private const val MAX_SIZE = 100000000

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val arr = readLine().split(" ").map { it.toInt() }.sorted()
        val dots = BooleanArray(MAX_SIZE * 2 + 1)
        for (pos in arr) {
            dots[pos + MAX_SIZE] = true
        }
        var cnt = 0
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                val pos = 2 * arr[j] - arr[i] + MAX_SIZE
                if (pos <= dots.lastIndex && dots[pos]) {
                    cnt++
                }
            }
        }
        println(cnt)
    }
    close()
}