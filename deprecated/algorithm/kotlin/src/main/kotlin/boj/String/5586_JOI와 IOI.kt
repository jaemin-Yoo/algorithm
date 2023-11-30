package boj.String

fun main() {
    val s = readln()
    var JOI = 0
    var IOI = 0
    for (i in 0..s.length - 3) {
        val str = "" + s[i] + s[i+1] + s[i+2]
        if (str == "JOI") JOI += 1 else if (str == "IOI") IOI += 1
    }
    println(JOI)
    println(IOI)
}