package boj.String

fun main() {
    val (c, p) = readLine()!!.split(':').map { it.toInt() }
    val g = gcd(c, p)
    println("${c / g}:${p / g}")
}

fun gcd(x: Int, y: Int): Int {
    var a = x
    var b = y
    while(b > 0) {
        val mod = a % b
        a = b
        b = mod
    }

    return a
}