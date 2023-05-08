package boj.Greedy

fun main() {
    val (l, r) = readln().split(" ").map { it.toLong() }
    var a = l.toString()
    val b = r.toString()
    a = a.padStart(b.length, '0')

    var cnt = 0
    for (i in a.indices) {
        if (a[i] != b[i]) break
        if (a[i] == '8') cnt += 1
    }

    println(cnt)
}