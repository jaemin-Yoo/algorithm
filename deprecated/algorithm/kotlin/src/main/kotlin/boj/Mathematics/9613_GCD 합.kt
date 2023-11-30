package boj.Mathematics

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val list = readln().split(" ").map { it.toInt() }
        var result = 0L
        for (i in 1 until list.lastIndex) {
            for (j in i + 1..list.lastIndex) {
                result += gcd(list[i], list[j])
            }
        }
        println(result)
    }
}

fun gcd(x: Int, y: Int): Int {
    var a = x
    var b = y
    while (b > 0) {
        val mod = a % b
        a = b
        b = mod
    }
    return a
}