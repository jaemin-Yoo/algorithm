package boj.String

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln()
        val result = (n.toInt() + n.reversed().toInt()).toString()
        println(if (result == result.reversed()) "YES" else "NO")
    }
}