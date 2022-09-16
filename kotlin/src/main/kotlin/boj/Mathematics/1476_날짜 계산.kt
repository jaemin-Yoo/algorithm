package boj.Mathematics

fun main() {
    val (e, s, m) = readln().split(' ').map { it.toInt() }
    var (a, b, c, cnt) = listOf(0, 0, 0, 0)
    while (true) {
        if (a == e && b == s && c == m) break

        a = a % 15 + 1
        b = b % 28 + 1
        c = c % 19 + 1
        cnt += 1
    }
    println(cnt)
}