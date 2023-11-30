package boj.Implementation

fun main() {
    val x = readln().toInt()
    val n = readln().toInt()
    var result = 0
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        result += a * b
    }
    println(
        if (result == x) {
            "Yes"
        } else {
            "No"
        }
    )
}