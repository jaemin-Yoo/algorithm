package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val (n, q) = readLine().split(" ").map { it.toInt() }
    val question = readLine().split(" ").map { it.toInt() }.sorted()
    val ps = Array(n + 1) { 0 }
    for (i in question.indices) {
        ps[i + 1] = question[i] + ps[i]
    }

    val sb = StringBuilder()
    repeat(q) {
        val (l, r) = readLine().split(" ").map { it.toInt() }
        sb.append("${ps[r] - ps[l - 1]}\n")
    }
    println(sb.toString())
    close()
}