package boj.String

fun main() {
    var s = readln()

    var cnt = 0
    while(s.length > 1) {
        s = s.map { it - '0' }.sum().toString()
        cnt += 1
    }
    println(cnt)
    println(if (s.toInt() % 3 == 0) "YES" else "NO")
}