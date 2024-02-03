package boj.implementation

/**
 * 문제 번호: (8979)
 * 문제 이름: (올림픽)
 * 소요 시간(분): (14)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val countries = Array(n + 1) { Triple(0, 0, 0) }
    repeat(n) {
        val (i, gold, silver, brown) = readLine().split(" ").map { it.toInt() }
        countries[i] = Triple(gold, silver, brown)
    }
    val rank = countries.sortedWith(compareByDescending<Triple<Int, Int, Int>> { it.first }.thenByDescending { it.second }.thenByDescending { it.third })
    for (i in 0 until n) {
        if (rank[i] == countries[k]) {
            println(i + 1)
            break
        }
    }
    close()
}