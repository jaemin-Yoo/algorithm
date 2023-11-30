package boj.Implementation.공넣기10810

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val basket = IntArray(n) { 0 }
    repeat(m) {
        val (i, j, k) = readln().split(" ").map { it.toInt() }
        for (idx in i..j) {
            basket[idx - 1] = k
        }
    }
    print(basket.joinToString(" "))
}