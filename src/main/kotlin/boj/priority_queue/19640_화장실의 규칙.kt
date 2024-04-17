package boj.priority_queue

/**
 * 문제 번호: (19640)
 * 문제 이름: (화장실의 규칙)
 * 소요 시간(분): (60)
 */

import java.util.LinkedList
import kotlin.math.min
import java.util.PriorityQueue

data class Employee(val num: Int, val d: Int, val h: Int, val idx: Int)

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m, k) = br.readLine().split(' ').map { it.toInt() }
    val lineCount = min(n, m)
    val line = Array(lineCount) { LinkedList<Employee>() }
    repeat(n) { num ->
        val (d, h) = br.readLine().split(' ').map { it.toInt() }
        val idx = num % lineCount
        line[idx].add(Employee(num, d, h, idx))
    }

    val pq = PriorityQueue<Employee> { a, b ->
        if (a.d != b.d) {
            b.d - a.d
        } else if (a.h != b.h) {
            b.h - a.h
        } else {
            a.idx - b.idx
        }
    }
    line.forEach { pq.add(it.removeFirst()) }

    var cnt = 0
    for (i in 0 until n) {
        val e = pq.poll()
        if (e.num == k) break

        if (line[e.idx].isNotEmpty()) {
            pq.add(line[e.idx].removeFirst())
        }
        cnt++
    }
    println(cnt)
}