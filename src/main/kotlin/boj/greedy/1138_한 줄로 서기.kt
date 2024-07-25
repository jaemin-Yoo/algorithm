package boj.greedy

/**
 * 문제 번호: (1138)
 * 문제 이름: (한 줄로 서기)
 * 소요 시간(분): (7)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val people = br.readLine().split(' ').map { it.toInt() }
    val lines = mutableListOf<Int>()
    for (i in n downTo 1) {
        val count = people[i - 1]
        lines.add(count, i)
    }
    println(lines.joinToString(" "))
}