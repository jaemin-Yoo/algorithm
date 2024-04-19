package boj.topological_sorting

/**
 * 문제 번호: (1889)
 * 문제 이름: (선물 교환)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val students = BooleanArray(n + 1) { true }
    val receivePresent = IntArray(n + 1)
    val sendPresent = Array(n + 1) { 0 to 0 }
    repeat(n) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        sendPresent[it + 1] = a to b
        receivePresent[a]++
        receivePresent[b]++
    }
    check(students, sendPresent, receivePresent, n)

    val result = mutableListOf<Int>()
    for (i in 1 until n + 1) {
        if (students[i]) {
            result.add(i)
        }
    }
    if (result.isEmpty()) {
        println(0)
    } else {
        println(result.size)
        println(result.joinToString(" "))
    }
}

private fun check(students: BooleanArray, sendPresent: Array<Pair<Int, Int>>, receivePresent: IntArray, n: Int) {
    val q: Queue<Int> = LinkedList()
    for (i in 1 until n + 1) {
        if (receivePresent[i] < 2) {
            students[i] = false
            q.add(i)
        }
    }

    while (q.isNotEmpty()) {
        val std = q.poll()
        val a = sendPresent[std].first
        val b = sendPresent[std].second
        if (students[a] && --receivePresent[a] < 2) {
            students[a] = false
            q.add(a)
        }
        if (students[b] && --receivePresent[b] < 2) {
            students[b] = false
            q.add(b)
        }
    }
}