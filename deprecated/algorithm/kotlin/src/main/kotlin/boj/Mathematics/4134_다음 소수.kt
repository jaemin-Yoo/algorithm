package boj.Mathematics

fun main() {
    val t = readln().toInt()
    repeat(t) {
        var n = readln().toLong()
        while (isPrimeNumber(n).not()) {
            n += 1L
        }
        println(n)
    }
}

fun isPrimeNumber(n: Long): Boolean {
    if (n <= 1L) {
        return false
    }

    var i = 2L
    while (i * i <= n) {
        if (n % i == 0L) {
            return false
        }
        i += 1L
    }

    return true
}