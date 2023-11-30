package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val input = readLine() ?: break
        val (s, t) = input.split(" ")

        var start = 0
        var result = "Yes"
        for (c in s) {
            start = t.indexOf(c, start) + 1
            if (start == 0) {
                result = "No"
            }
        }
        println(result)
    }

    close()
}