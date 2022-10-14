package com.jaemin.practicekotlin

import java.util.PriorityQueue

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it.toInt() }

        val pq = PriorityQueue<Int>()
        val result = mutableListOf<Int>()
        for (i in list.indices) {
            pq.add(list[i])
            if (i % 2 == 0) {
                val center = if (i == 0) {
                    pq.poll()
                } else {
                    pq.poll()
                    val center = pq.poll()
                    pq.poll()
                    center
                }
                result.add(center)
                pq.add(center)
            }
        }
        println(n / 2 + 1)
        println(result.joinToString(" "))
    }
}