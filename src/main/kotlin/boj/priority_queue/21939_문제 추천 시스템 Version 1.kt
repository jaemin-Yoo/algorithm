package boj.priority_queue

/**
 * 문제 번호: (21939)
 * 문제 이름: (문제 추천 시스템 Version 1)
 * 소요 시간(분): (40)
 */

import java.util.PriorityQueue

private const val MAX_P_NUMBER = 100000

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val maxHeap = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.second == b.second) {
            b.first - a.first
        } else {
            b.second - a.second
        }
    }
    val minHeap = PriorityQueue<Pair<Int, Int>> { a, b ->
        if (a.second == b.second) {
            a.first - b.first
        } else {
            a.second - b.second
        }
    }
    val existsPList = IntArray(MAX_P_NUMBER + 1)
    repeat(n) {
        val (p, l) = readLine().split(" ").map{ it.toInt() }
        existsPList[p] = l
        maxHeap.add(p to l)
        minHeap.add(p to l)
    }
    val m = readLine().toInt()
    repeat(m) {
        val c = readLine()
        startCommand(c, existsPList, minHeap, maxHeap)
    }
    close()
}

private fun startCommand(c: String, existsPList: IntArray, minHeap: PriorityQueue<Pair<Int, Int>>, maxHeap: PriorityQueue<Pair<Int, Int>>) {
    val list = c.split(" ")

    when (list[0]) {
        "recommend" -> {
            val n = list[1].toInt()
            val p = if (n == 1) {
                maxHeap.peek().first
            } else {
                minHeap.peek().first
            }

            println(p)
        }
        "add" -> {
            val (p, l) = list[1].toInt() to list[2].toInt()
            minHeap.add(p to l)
            maxHeap.add(p to l)
            existsPList[p] = l
        }
        "solved" -> {
            val p = list[1].toInt()
            existsPList[p] = 0

            while (minHeap.isNotEmpty() && minHeap.peek().first == p) {
                minHeap.poll()
            }

            while (maxHeap.isNotEmpty() && maxHeap.peek().first == p) {
                maxHeap.poll()
            }
        }
    }
}