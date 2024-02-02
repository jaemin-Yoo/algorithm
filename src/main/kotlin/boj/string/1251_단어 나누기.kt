package boj.string

/**
 * 문제 번호: (1251)
 * 문제 이름: (단어 나누기)
 * 소요 시간(분): (25)
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val words = mutableSetOf<String>()
    for (i in 1 until s.length - 1) {
        for (j in i + 1 until s.length) {
            words.add(s.substring(0, i).reversed() + s.substring(i, j).reversed() + s.substring(j, s.length).reversed())
        }
    }
    val result = words.sorted()[0]
    println(result)
    close()
}