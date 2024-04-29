package boj.data_structures

/**
 * 문제 번호: (5464)
 * 문제 이름: (주차장)
 * 소요 시간(분): (20)
 */

import java.util.PriorityQueue
import java.util.Queue
import java.util.LinkedList

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val parkingLot = IntArray(n + 1)
    val cars = IntArray(m + 1)
    val carPos = IntArray(m + 1)
    val pq = PriorityQueue<Int>()
    val waiting: Queue<Int> = LinkedList()
    var result = 0
    for (i in 1 until n + 1) {
        pq.add(i)
    }
    repeat(n) { i ->
        val s = br.readLine().toInt()
        parkingLot[i + 1] = s
    }
    repeat(m) { i ->
        val w = br.readLine().toInt()
        cars[i + 1] = w
    }
    repeat(2 * m) {
        val car = br.readLine().toInt()
        if (car > 0) {
            waiting.add(car)
        } else {
            val pL = carPos[-car]
            pq.add(pL)
            result += cars[-car] * parkingLot[pL]
        }

        if (pq.isNotEmpty() && waiting.isNotEmpty()) {
            val c = waiting.poll()
            carPos[c] = pq.poll()
        }
    }
    println(result)
}