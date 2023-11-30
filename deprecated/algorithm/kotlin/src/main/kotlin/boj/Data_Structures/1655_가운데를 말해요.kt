package boj.Data_Structures

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val result = StringBuilder()
    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
    var center = 0
    repeat(n) {
        val m = readln().toInt()
        if (result.isEmpty()) {
            result.appendLine(m)
            center = m
        } else {
            if (m > center) {
                minHeap.add(m)
            } else {
                maxHeap.add(m)
            }

            if (minHeap.size == maxHeap.size) {
                result.appendLine(center)
            } else if (minHeap.size == maxHeap.size + 2) {
                maxHeap.add(center)
                center = minHeap.poll()
                result.appendLine(center)
            } else if (minHeap.size + 2 == maxHeap.size) {
                minHeap.add(center)
                center = maxHeap.poll()
                result.appendLine(center)
            } else if (minHeap.size == maxHeap.size + 1) {
                val a = minHeap.peek()
                if (center > a) {
                    result.appendLine(a)
                } else {
                    result.appendLine(center)
                }
            } else if (minHeap.size + 1 == maxHeap.size) {
                val a = maxHeap.peek()
                if (center > a) {
                    result.appendLine(a)
                } else {
                    result.appendLine(center)
                }
            }
        }
    }

    println(result.toString())
}