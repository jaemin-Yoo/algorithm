package boj.String

fun main() {
    val s = readln()
    println(s.map {
        var c = it.code - 3
        if (c < 65) c += 26
        c.toChar()
    }.joinToString(""))
}