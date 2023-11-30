package boj.String

fun main() {
    val n = readln().toInt()
    repeat(n) {
        val (a, b) = readln().split(' ')
        var state = ""
        for (i in 97..123) {
            val aCount = a.count { it == i.toChar() }
            val bCount = b.count { it == i.toChar() }
            if (aCount != bCount) {
                state = " NOT"
                break
            }
        }

        println("$a & $b are$state anagrams.")
    }
}