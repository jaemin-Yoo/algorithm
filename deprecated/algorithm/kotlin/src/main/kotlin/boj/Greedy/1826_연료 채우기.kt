package boj.Greedy

import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val stations = mutableListOf<OilStation>()
    repeat(n) {
        val (a, b) = readln().split(" ").map{ it.toInt() }
        stations.add(OilStation(a, b))
    }
    val (l, p) = readln().split(" ").map{ it.toInt() }

    stations.sortBy { it.distance }
    var maxDist = p
    var cnt = 0
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    for ((distance, amount) in stations) {
        while (maxDist < distance && pq.isNotEmpty()) {
            maxDist += pq.poll()
            cnt += 1
        }
        if (maxDist < distance) {
            break
        }

        pq.add(amount)
    }

    while (maxDist < l && pq.isNotEmpty()) {
        maxDist += pq.poll()
        cnt += 1
    }

    val result = if (maxDist >= l) {
        cnt
    } else {
        -1
    }
    println(result)
}

data class OilStation(
    val distance: Int,
    val amount: Int
)