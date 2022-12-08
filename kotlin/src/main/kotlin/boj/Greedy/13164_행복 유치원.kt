package boj.Greedy

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }
    val diff = mutableListOf<Int>()
    for (i in 1 until n) {
        diff.add(list[i] - list[i - 1])
    }
    diff.sort()
    println(diff.subList(0, n - k).sum())

    close()
}