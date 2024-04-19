package boj.priority_queue

/**
 * 문제 번호: (14698)
 * 문제 이름: (전생했더니 슬라임 연구자였던 건에 대하여 (Hard))
 * 소요 시간(분): (x)
 */

import java.util.PriorityQueue

private const val MOD = 1_000_000_007

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = br.readLine().toInt()
        val slimes = br.readLine().split(' ').map { it.toLong() }
        val pq = PriorityQueue<Long>()
        slimes.forEach {
            pq.add(it)
        }

        var result = 1L
        while (pq.size > 1) {
            val a = pq.poll()
            val b = pq.poll()
            val newSlime = a * b
            pq.add(newSlime)
            result = (result * (newSlime % MOD)) % MOD
        }
        sb.appendLine(result)
    }
    println(sb)
}