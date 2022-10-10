package boj.String

fun main() {
    val (a, b, c, d) = readln().split(" ")
    println((a + b).toLong() + (c + d).toLong())
}