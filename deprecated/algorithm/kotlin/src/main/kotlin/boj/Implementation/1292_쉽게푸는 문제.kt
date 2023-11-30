package boj.Implementation

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    for (i in 1..100) {
        repeat(i) {
            list.add(i)
        }
    }

    var result = 0
    for (i in n - 1 until m) {
        result += list[i]
    }
    println(result)
}