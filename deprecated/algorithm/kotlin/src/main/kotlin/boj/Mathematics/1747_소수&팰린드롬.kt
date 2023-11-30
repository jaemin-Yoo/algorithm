package boj.Mathematics

fun main() {
    var n = readln().toInt()
    while (isPrimeNumber(n).not() || isPalindrome(n).not()) {
        n += 1
    }
    println(n)
}

fun isPrimeNumber(n: Int): Boolean {
    if (n == 1) {
        return false
    }

    var i = 2
    while (i * i <= n) {
        if (n % i == 0) {
            return false
        }

        i += 1
    }
    return true
}

fun isPalindrome(n: Int): Boolean {
    val s = n.toString()
    for (i in 0 until s.length / 2) {
        if (s[i] != s[s.lastIndex - i]) {
            return false
        }
    }
    return true
}