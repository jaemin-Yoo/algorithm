package boj.data_structures

/**
 * 문제 번호: (2164)
 * 문제 이름: (카드2)
 * 소요 시간(분): (8)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val q = ArrayDeque<Int>()
    for (i in 1 until n + 1) {
        q.add(i)
    }

    while (q.size > 1) {
        q.removeFirst()
        val a = q.removeFirst()
        q.add(a)
    }
    println(q.last())
}