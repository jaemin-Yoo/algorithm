package boj.String

fun main() {
    val n = readln()
    if (n[0] == '0') {
        if (n[1] == 'x') {
            println(Integer.parseInt(n.substring(2, n.length), 16))
        } else println(Integer.parseInt(n, 8))
    } else println(n)
}