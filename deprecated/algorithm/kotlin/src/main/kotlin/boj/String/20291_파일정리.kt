package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = sortedMapOf<String, Int>()
    repeat(n) {
        val s = readLine().split(".")[1]
        map[s] = map.getOrDefault(s, 0) + 1
    }
    map.forEach { (k, v) ->
        println("$k $v")
    }

    close()
}