package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine().replace("\\d".toRegex(), "")
    val key = readLine()

    println(
        if (s.contains(key)) {
            1
        } else {
            0
        }
    )
    close()
}