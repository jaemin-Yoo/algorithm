package boj.Greedy.파일합치기13975

import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val k = readln().toInt()
        val list = readln().split(" ").map{ it.toLong() }
        val pq = PriorityQueue<Long>()
        for (i in list) {
            pq.add(i)
        }

        var result = 0L
        while (pq.size > 1) {
            val a = pq.poll()
            val b = pq.poll()
            val c =  a + b
            pq.add(c)
            result += c
        }

        println(result)
    }
}