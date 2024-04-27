package boj.implementation

/**
 * 문제 번호: (3613)
 * 문제 이름: (Java vs C++)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val s = br.readLine()
    val cppRegex = Regex("[a-z]+(_[a-z]+)*")
    val javaRegex = Regex("[a-z]+[a-zA-Z]*")
    if (s.matches(cppRegex)) {
        println(cppToJava(s))
    } else if (s.matches(javaRegex)) {
        println(javaToCpp(s))
    } else {
        println("Error!")
    }
}

private fun javaToCpp(s: String): String {
    val sb = StringBuilder()
    s.forEach { c ->
        if (c.isUpperCase()) {
            sb.append("_${c.lowercase()}")
        } else {
            sb.append(c)
        }
    }
    return sb.toString()
}

private fun cppToJava(s: String): String {
    val sb = StringBuilder()
    var isUpper = false
    s.forEach { c ->
        if (c == '_') {
            isUpper = true
        } else if (isUpper) {
            sb.append(c.uppercase())
            isUpper = false
        } else {
            sb.append(c)
        }
    }
    return sb.toString()
}