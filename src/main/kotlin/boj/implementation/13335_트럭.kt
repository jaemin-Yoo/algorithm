package boj.implementation

/**
 * 문제 번호: (13335)
 * 문제 이름: (트럭)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, w, l) = readLine().split(" ").map { it.toInt() }
    val wArr = readLine().split(" ").map { it.toInt() }
    var wSum = 0
    var time = 0
    val bridge: Queue<Int> = LinkedList()
    for (i in 0 until n) {
        val truck = wArr[i]
        while (true) {
            while (bridge.isNotEmpty() && bridge.peek() == 0) {
                bridge.poll()
            }
            if (bridge.size >= w) {
                wSum -= bridge.poll()
            }
            if (wSum + truck <= l) {
                bridge.add(truck)
                wSum += truck
                time++
                break
            } else {
                while (bridge.size < w) {
                    bridge.add(0)
                    time++
                }
            }
        }
    }

    if (bridge.isNotEmpty()) {
        time += w
    }
    println(time)
    close()
}