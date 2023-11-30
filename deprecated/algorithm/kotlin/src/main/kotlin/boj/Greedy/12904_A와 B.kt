package boj.Bruteforcing

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    var t = readLine()

    while (s.length < t.length) {
        if (t.last() == 'A') {
            t = t.substring(0, t.lastIndex)
        } else {
            t = t.substring(0, t.lastIndex)
            t = t.reversed()
        }
    }

    val result = if (s == t) {
        1
    } else {
        0
    }
    println(result)
    close()
}