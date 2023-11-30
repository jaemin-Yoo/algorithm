package boj.Greedy

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val list = readln().split(" ").map { it[0] }
        var standard = list[0]
        var result = ""
        for (c in list) {
            if (c.code <= standard.code) {
                result = c + result
            } else {
                result += c
            }
            standard = result[0]
        }
        println(result)
    }
}