package boj.greedy

/**
 * 문제 번호: (11501)
 * 문제 이름: (주식)
 * 소요 시간(분): (13)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val arr = br.readLine().split(' ').map { it.toInt() }
        var result = 0L
        var maxValue = arr[n - 1]
        for (i in n - 2 downTo 0) {
            if (arr[i] >= maxValue) {
                maxValue = arr[i]
            } else {
                result += maxValue - arr[i]
            }
        }
        println(result)
    }
}