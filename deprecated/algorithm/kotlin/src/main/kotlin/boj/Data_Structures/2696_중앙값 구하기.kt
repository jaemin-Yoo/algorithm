package boj.Data_Structures

import java.util.*
import kotlin.math.ceil

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val seq = mutableListOf<Int>()
        repeat(ceil(n / 10.0).toInt()) {
            val row = readln().split(" ").map { it.toInt() }
            seq.addAll(row)
        }
        val result = mutableListOf<Int>()
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        var std = seq[0]
        result.add(std)
        for (i in 1 until n) {
            val v = seq[i]
            if (std < v) {
                minHeap.add(v)
            } else {
                maxHeap.add(v)
            }

            if (i % 2 == 0) {
                if (maxHeap.size > minHeap.size) {
                    minHeap.add(std)
                    std = maxHeap.poll()
                } else if (maxHeap.size < minHeap.size) {
                    maxHeap.add(std)
                    std = minHeap.poll()
                }
                result.add(std)
            }
        }

        println(n / 2 + 1)
        for (i in result.indices) {
            val str = result[i].toString() + if (i % 9 == 0 && i != 0) {
                "\n"
            } else {
                " "
            }
            print(str)
        }
    }
}