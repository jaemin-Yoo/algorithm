package boj.implementation

/**
 * 문제 번호: (2161)
 * 문제 이름: (카드1)
 * 소요 시간(분): (3)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val q: Queue<Int> = LinkedList()
    for (i in 1 until n + 1) {
        q.add(i)
    }

    val result = mutableListOf<Int>()
    while (q.isNotEmpty()) {
        val num = q.poll()
        result.add(num)
        if (q.isEmpty()) break

        q.add(q.poll())
    }
    println(result.joinToString(" "))
    close()
}