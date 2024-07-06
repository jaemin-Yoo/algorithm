package boj.greedy

/**
 * 문제 번호: (13305)
 * 문제 이름: (주유소)
 * 소요 시간(분): (16)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val distances = br.readLine().split(' ').map { it.toLong() }
    val gasStations = br.readLine().split(' ').map { it.toLong() }
    var minCost = Int.MAX_VALUE.toLong()
    var result = 0L
    for (i in 0 until n - 1) {
        if (minCost > gasStations[i]) {
            minCost = gasStations[i]
        }
        result += minCost * distances[i]
    }
    println(result)
}