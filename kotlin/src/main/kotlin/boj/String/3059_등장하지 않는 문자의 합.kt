package boj.String

fun main() {
    repeat(readln().toInt()) {
        val s = readln()
        var result = 0
        for (i in 65..90) {
            if (i.toChar() !in s) result += i
        }
        println(result)
    }
}