package boj.String

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val s = readLine()!!
        println("${s[0]}${s[s.length - 1]}")
    }
}