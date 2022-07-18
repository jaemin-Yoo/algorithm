package boj.String

fun main() {
    val s = readLine()!!
    for (c in s) {
        if (c.isUpperCase()) {
            print(c.lowercase())
        } else {
            print(c.uppercase())
        }
    }
}