package boj.String

fun main() {
    var a = readLine()!!
    val op = readLine()!!
    var b = readLine()!!

    if (b.length > a.length) {
        val temp = a
        a = b
        b = temp
    }

    val result = if (op == "+") {
        if (a.length == b.length) "2" + a.substring(1, a.length) else a.substring(0, a.length - b.length) + b
    } else {
        a + "0".repeat(b.length - 1)
    }
    println(result)
}