package boj.string

/**
 * 문제 번호: (5555)
 * 문제 이름: (반지)
 * 소요 시간(분): (5)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val findRingStr = readLine()
    val n = readLine().toInt()
    var cnt = 0
    repeat(n) {
        val str = readLine()
        for (i in str.indices) {
            val subString = (str + str).substring(i, i + findRingStr.length)
            if (findRingStr == subString) {
                cnt++
                break
            }
        }
    }
    println(cnt)
    close()
}