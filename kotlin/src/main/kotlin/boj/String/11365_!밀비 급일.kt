package boj.String

fun main() {
    while(true) {
        val s = readLine()!!
        if (s == "END") break
        s.reversed().forEach { print(it) }
        println()
    }
}