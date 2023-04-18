package boj.Greedy.보석도둑1202

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val jewels = PriorityQueue<Jewel>()
    repeat(n) {
        val (m, v) = readln().split(" ").map { it.toInt() }
        jewels.add(Jewel(m, v))
    }

    val bags = mutableListOf<Int>()
    repeat(k) {
        val c = readln().toInt()
        bags.add(c)
    }
    bags.sort()

    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var result = 0L

    for (c in bags) {
        while (jewels.isNotEmpty()) {
            if (jewels.peek().m <= c) {
                pq.add(jewels.poll().v)
            } else {
                break
            }
        }

        if (pq.isNotEmpty()) {
            result += pq.poll()
        }
    }
    println(result)
}

data class Jewel(
    val m: Int,
    val v: Int
) : Comparable<Jewel> {
    override fun compareTo(other: Jewel): Int {
        return if (this.m != other.m) {
            this.m - other.m
        } else {
            other.v - this.v
        }
    }
}