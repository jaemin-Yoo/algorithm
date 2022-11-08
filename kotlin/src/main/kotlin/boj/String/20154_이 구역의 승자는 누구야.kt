package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    val map = mapOf(
        'A' to 3, 'B' to 2, 'C' to 1, 'D' to 2, 'E' to 3,
        'F' to 3, 'G' to 3, 'H' to 3, 'I' to 1, 'J' to 1,
        'K' to 3, 'L' to 1, 'M' to 3, 'N' to 3, 'O' to 1,
        'P' to 2, 'Q' to 2, 'R' to 2, 'S' to 1, 'T' to 2,
        'U' to 1, 'V' to 1, 'W' to 2, 'X' to 2, 'Y' to 2,
        'Z' to 1
    )

    val s = readLine()
    var result = 0
    s.forEach {
        result += map.getOrDefault(it, 0)
    }

    println(
        if (result % 2 == 0) {
            "You're the winner?"
        } else {
            "I'm a winner!"
        }
    )
}