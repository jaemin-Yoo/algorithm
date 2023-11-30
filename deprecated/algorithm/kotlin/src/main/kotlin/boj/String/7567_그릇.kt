package boj.String

fun main() {
    val s = readLine()!!
    var state = ""
    var result = 0
    s.forEach {
        result += if (it.toString() == state) 5 else 10
        state = it.toString()
    }
    println(result)
}