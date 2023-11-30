package boj.Mathematics

fun main() {
    val arr = mutableListOf<Int>()
    repeat(7) {
        arr.add(readln().toInt())
    }
    val s = arr.filter { it % 2 == 1 }
    if (s.isEmpty()) {
        println(-1)
    } else {
        println(s.sum())
        println(s.minOf { it })
    }
}