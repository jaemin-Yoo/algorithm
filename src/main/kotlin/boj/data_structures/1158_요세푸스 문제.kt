package boj.data_structures

/**
 * 문제 번호: (1158)
 * 문제 이름: (요세푸스 문제)
 * 소요 시간(분): (30)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val result = mutableListOf<Int>()
    val q: Queue<Int> = LinkedList()
    for (i in 1 until n + 1) {
        q.add(i)
    }

    while (result.size < n) {
        repeat(k - 1) { q.add(q.poll()) }
        result.add(q.poll())
    }

    println("<${result.joinToString(", ")}>")
}

/*

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val a = BooleanArray(n)
    val result = mutableListOf<Int>()
    var i = 0
    var cnt = 0
    while (true) {
        if (result.size == n) break

        if (!a[i]) {
            cnt++
        }

        if (cnt == k) {
            a[i] = true
            result.add(i + 1)
            cnt = 0
        }
        i = (i + 1) % n
    }
    println("<" + result.joinToString(", ") + ">")
}

 */