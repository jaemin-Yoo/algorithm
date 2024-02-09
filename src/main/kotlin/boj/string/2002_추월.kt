package boj.string

/**
 * 문제 번호: (2002)
 * 문제 이름: (추월)
 * 소요 시간(분): (19)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = mutableListOf<String>()
    for (i in 0 until n) {
        val s = readLine()
        arr.add(s)
    }

    var cnt = 0
    for (i in 0 until n) {
        val s = readLine()
        if (arr.first() == s) {
            arr.removeFirst()
        } else {
            arr.remove(s)
            cnt++
        }
    }
    println(cnt)
    close()
}