package boj.Greedy

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.sorted()

    var s = 1
    list.forEach { v ->
        if (s < v) return@forEach
        s += v
    }

    println(s)
    close()
}