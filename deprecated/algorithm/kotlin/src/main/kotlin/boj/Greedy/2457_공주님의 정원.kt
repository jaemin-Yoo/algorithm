package boj.Greedy

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val lastDay = listOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val pq = PriorityQueue<Pair<Date, Date>> { a, b ->
        if (a.first.m < b.first.m) {
            -1
        } else if (a.first.m > b.first.m) {
            1
        } else {
            if (a.first.d < b.first.d) {
                -1
            } else if (a.first.d > b.first.d) {
                1
            } else {
                0
            }
        }
    }
    repeat(n) {
        val (fromM, fromD, toM, toD) = readln().split(" ").map { it.toInt() }
        pq.add(Date(fromM, fromD) to Date(toM, toD))
    }

    var m = 3
    var d = 1
    val maxToPq = PriorityQueue<Date> { a, b ->
        if (a.m < b.m) {
            1
        } else if (a.m > b.m) {
            -1
        } else {
            if (a.d < b.d) {
                1
            } else if (a.d > b.d) {
                -1
            } else {
                0
            }
        }
    }
    var cnt = 0
    while (true) {
        while (pq.isNotEmpty()) {
            val (from, to) = pq.peek()
            if (from.m < m || (from.m == m && from.d <= d)) {
                val (_, t) = pq.poll()
                if ((to.m > m || (to.m == m && to.d > d))) {
                    maxToPq.add(t)
                }
            } else {
                break
            }
        }

        if (maxToPq.isNotEmpty()) {
            val (month, day) = maxToPq.poll()
            m = month
            d = day

            cnt += 1
            if (m >= 12) {
                break
            }
        } else {
            break
        }
    }

    val result = if (m < 12) {
        0
    } else {
        cnt
    }
    println(result)
}

data class Date(
    val m: Int,
    val d: Int
)