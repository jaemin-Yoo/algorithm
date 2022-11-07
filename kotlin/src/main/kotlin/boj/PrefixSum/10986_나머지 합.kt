package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }
    val pSum = LongArray(n + 1)
    val remainderList = LongArray(m)

    for (i in 1..n) {
        pSum[i] = (pSum[i - 1] + list[i - 1]) % m
        remainderList[pSum[i].toInt()]++
    }

    var result = remainderList[0]
    for (i in 0 until m) {
        val rm = remainderList[i]
        result += rm * (rm - 1) / 2
    }

    println(result)
}