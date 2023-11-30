package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }

    val map = mutableMapOf<Long, Long>()
    val pSum = LongArray(n + 1) { 0 }
    var result = 0L
    for (i in 1..n) {
        pSum[i] = pSum[i - 1] + list[i - 1]
        if (pSum[i] == k.toLong()) {
            result += 1
        }
        result += map.getOrDefault(pSum[i] - k, 0)
        map[pSum[i]] = map.getOrDefault(pSum[i], 0) + 1
    }

    println(result)
}