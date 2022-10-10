package boj.Data_Structures

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = MutableList(n) { it + 1 }
    val result = mutableListOf<Int>()

    var idx = 0
    while (arr.isNotEmpty()) {
        idx = (idx + k - 1) % arr.size
        result.add(arr.removeAt(idx))
    }
    println(result.joinToString(", ", "<", ">"))
}