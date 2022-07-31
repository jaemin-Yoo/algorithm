package boj.String

fun main() {
    var s = readLine()!!

    var cnt = 0
    while(s.length > 1) {
        var ans = 0
        for (c in s) {
            ans += c - '0'
        }
        s = ans.toString()
        cnt += 1
    }
    println(cnt)
    println(if (s.toInt() % 3 == 0) "YES" else "NO")
}