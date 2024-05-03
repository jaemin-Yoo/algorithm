package boj.data_structures

/**
 * 문제 번호: (2164)
 * 문제 이름: (카드2)
 * 소요 시간(분): (4)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    for (i in 1 until n + 1) {
        deque.add(i)
    }
    while (deque.size > 1) {
        deque.removeFirst()
        deque.add(deque.removeFirst())
    }
    println(deque.removeFirst())
}