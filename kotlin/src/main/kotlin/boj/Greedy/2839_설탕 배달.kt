package boj.Greedy

fun main() {
    val n = readln().toInt()
    val fiveCount = n / 5
    var result = -1
    for (i in fiveCount downTo 0) {
        val diff = n - i * 5
        if (diff %  3 == 0) {
            result = diff / 3 + i
            break
        }
    }

    if (result == -1 && n % 3 == 0) {
        result = n / 3
    }

    println(result)
}