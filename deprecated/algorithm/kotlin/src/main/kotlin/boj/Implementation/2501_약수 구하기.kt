package boj.Implementation

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val s = sortedSetOf<Int>()
    for (i in 1..n) {
        if (n % i == 0) {
            s.add(i)
        }
    }
    if (s.size < k) {
        println(0)
    } else {
        println(s.toMutableList()[k - 1])
    }
}