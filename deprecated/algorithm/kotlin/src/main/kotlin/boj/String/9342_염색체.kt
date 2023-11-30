package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val regex = "^[A-F]?A+F+C+[A-F]?$".toRegex()
    repeat(n) {
        val result = if (readLine().matches(regex)) {
            "Infected!"
        } else {
            "Good"
        }
        println(result)
    }

    close()
}