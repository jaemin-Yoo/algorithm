package boj.String

fun main() {
    val (n, b) = readLine()!!.split(' ')
    var v = 1
    var result = 0
    for (c in n.reversed()) {
        result += if(c.isDigit()) {
            v * c.toString().toInt()
        } else {
            v * (c.code - 55)
        }
        v *= b.toInt()
    }
    println(result)
}