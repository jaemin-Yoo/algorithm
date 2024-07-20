package boj.greedy

/**
 * 문제 번호: (11501)
 * 문제 이름: (주식)
 * 소요 시간(분): (6)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        val arr = br.readLine().split(' ').map { it.toInt() }
        var maxValue = 0
        var result = 0L
        for (i in n - 1 downTo 0) {
            if (maxValue < arr[i]) {
                maxValue = arr[i]
            } else {
                result += maxValue - arr[i]
            }
        }
        sb.appendLine(result)
    }
    print(sb)
}