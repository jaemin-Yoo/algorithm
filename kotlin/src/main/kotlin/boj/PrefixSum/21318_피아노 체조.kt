package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val levels = readLine().split(" ").map { it.toInt() }

    val seq = Array(n + 1) { 0 }
    for (i in 0 until n - 1) {
        seq[i + 1] = if (levels[i] > levels[i + 1]) {
            1
        } else {
            0
        }
    }

    for (i in 1 until n) {
        seq[i] += seq[i - 1]
    }

    val q = readLine().toInt()
    val sb = StringBuilder()
    repeat(q) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        sb.append("${seq[y - 1] - seq[x - 1]}\n")
    }
    println(sb.toString())
}