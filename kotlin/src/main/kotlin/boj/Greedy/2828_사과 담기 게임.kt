package boj.Greedy

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val j = readln().toInt()
    var pos = m
    var result = 0
    repeat(j) {
        val p = readln().toInt()
        if (p > pos) {
            result += p - pos
            pos = p
        } else if (pos - m + 1 > p) {
            result += pos - m + 1 - p
            pos = p + m - 1
        }
    }
    println(result)
}