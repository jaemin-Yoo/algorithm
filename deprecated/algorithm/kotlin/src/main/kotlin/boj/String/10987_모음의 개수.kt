package boj.String

val vowel = listOf('a', 'e', 'i', 'o', 'u')

fun main() {
    val s = readLine()!!
    println(s.count { vowel.contains(it) })
}