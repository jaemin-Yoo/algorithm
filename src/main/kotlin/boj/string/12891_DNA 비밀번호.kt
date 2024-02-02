package boj.string

/**
 * 문제 번호: (12891)
 * 문제 이름: (DNA 비밀번호)
 * 소요 시간(분): (19)
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (s, p) = readLine().split(" ").map { it.toInt() }
    val dna = readLine()
    val (a, c, g, t) = readLine().split(" ").map { it.toInt() }
    var cnt = 0
    for (i in 0 until s - p + 1) {
        val s = dna.substring(i, i + p)
        val sa = s.count { it == 'A' }
        val sc = s.count { it == 'C' }
        val sg = s.count { it == 'G' }
        val st = s.count { it == 'T' }
        if (sa >= a && sc >= c && sg >= g && st >= t) {
            cnt++
        }
    }
    println(cnt)
}