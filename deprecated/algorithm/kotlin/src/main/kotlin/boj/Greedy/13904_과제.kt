package boj.Greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val dayList = mutableSetOf<Int>()
    val map = mutableMapOf<Int, MutableList<Int>>()
    val q = PriorityQueue<Int>(reverseOrder())
    repeat(n) {
        val (d, w) = readLine().split(" ").map { it.toInt() }

        if (map.containsKey(d)) {
            map[d]!!.add(w)
        } else {
            map[d] = mutableListOf(w)
        }

        dayList.add(d)
    }
    val list = dayList.sortedDescending()

    var result = 0
    for (d in list.maxOf { it } downTo  1) {
        if (map.containsKey(d)) {
            map[d]!!.forEach {
                q.add(it)
            }
        }

        if (q.isNotEmpty()) {
            result += q.poll()
        }
    }
    println(result)

    close()
}
