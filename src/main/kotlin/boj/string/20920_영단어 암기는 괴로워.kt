package boj.string

/**
 * 문제 번호: (20920)
 * 문제 이름: (영단어 암기는 괴로워)
 * 소요 시간(분): (x)
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Int>()
    repeat(n) {
        val word = readLine()
        if (word.length < m) return@repeat

        if (map.contains(word)) {
            map[word] = map[word]!! + 1
        } else {
            map[word] = 1
        }
    }

    val words = mutableListOf<Triple<String, Int, Int>>()
    for ((k, v) in map) {
        words.add(Triple(k, v, k.length))
    }
    words.sortWith(compareByDescending<Triple<String, Int, Int>> { it.second }.thenByDescending { it.third }.thenBy { it.first })

    val sb = StringBuilder()
    words.forEach {
        sb.append(it.first).append("\n")
    }
    println(sb)
}