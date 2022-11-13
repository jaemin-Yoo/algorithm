package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val n = readLine().toInt()
        val list = mutableListOf<Pair<String, String>>()

        if (n == 0) {
            break
        }

        repeat(n) {
            val s = readLine()
            list.add(s.lowercase() to s)
        }

        list.sortBy { it.first }

        println(list.first().second)
    }

    close()
}