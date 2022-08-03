package boj.String

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln()
        val rN = n.reversed()
        val result = (n.toInt() + rN.toInt()).toString()
        if (result == result.reversed()) {
            println("YES")
        } else println("NO")
    }
}