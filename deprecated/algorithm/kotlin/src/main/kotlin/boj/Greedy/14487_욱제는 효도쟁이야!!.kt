package boj.Greedy

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }
    println(list.sum() - list.maxOf { it })
    close()
}