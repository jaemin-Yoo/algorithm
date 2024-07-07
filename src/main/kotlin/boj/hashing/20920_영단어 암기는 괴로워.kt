package boj.hashing

/**
 * 문제 번호: (20920)
 * 문제 이름: (영단어 암기는 괴로워)
 * 소요 시간(분): (18)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val map = HashMap<String, Int>()
    repeat(n) {
        val s = br.readLine()
        if (s.length >= m) {
            if (map.containsKey(s)) {
                map[s] = map[s]!! + 1
            } else {
                map[s] = 1
            }
        }
    }

    val book = mutableListOf<Triple<Int, Int, String>>()
    for ((k, v) in map) {
        book.add(Triple(v, k.length, k))
    }
    book.sortWith(compareByDescending<Triple<Int, Int, String>> { it.first }.thenByDescending { it.second }.thenBy { it.third })

    val sb = StringBuilder()
    for ((_, _, word) in book) {
        sb.appendLine(word)
    }
    println(sb)
}