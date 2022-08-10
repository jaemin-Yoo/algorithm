package boj.String

fun main() {
    val sb = StringBuffer()
    while (true) {
        val s = readLine() ?: break
        sb.append(s)
    }

    var cnt = 0
    var result = ""
    for (i in 97..122) {
        val sbCount = sb.count { it == i.toChar()}
        if (cnt < sbCount) {
            cnt = sbCount
            result = i.toChar().toString()
        } else if (cnt == sbCount) {
            result += i.toChar()
        }
    }
    println(result)
}