package boj.String

fun main() {
    val myAh = readln()
    val doctorAh = readln()
    println(if (myAh.count { it == 'a' } >= doctorAh.count { it == 'a' }) "go" else "no")
}