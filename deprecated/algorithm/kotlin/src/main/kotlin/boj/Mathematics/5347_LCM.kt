package boj.Mathematics

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toLong() }
        println(lcm(a, b))
    }
}

fun gcd(a: Long, b: Long): Long {
    var x = a
    var y = b
    while (y > 0) {
        val mod = x % y
        x = y
        y = mod
    }

    return x
}

fun lcm(a: Long, b: Long): Long = a * b / gcd(a, b)