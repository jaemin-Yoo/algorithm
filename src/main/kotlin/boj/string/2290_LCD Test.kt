package boj.string

/**
 * 문제 번호: (2290)
 * 문제 이름: (LCD Test)
 * 소요 시간(분): (27)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (s, n) = readLine().split(" ")
    for (i in 0 until 2 * s.toInt() + 3) {
        val sb = StringBuilder()
        for (num in n) {
            sb.append(getRowNum(num, i, s.toInt()))
            sb.append(" ")
        }
        sb.deleteCharAt(sb.lastIndex)
        println(sb.toString())
    }
    
    close()
}

private fun getRowNum(num: Char, row: Int, s: Int): String {
    val list = when (num) {
        '1' -> mutableListOf<String>().apply {
            add(" " + " ".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + " ".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + " ".repeat(s) + " ")
        }
        '2' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + " ") }
            add(" " + "-".repeat(s) + " ")
        }
        '3' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
        }
        '4' -> mutableListOf<String>().apply {
            add(" " + " ".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + " ".repeat(s) + " ")
        }
        '5' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + " ") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
        }
        '6' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + " ") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
        }
        '7' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + " ".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + " ".repeat(s) + " ")
        }
        '8' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
        }
        '9' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add(" " + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
        }
        '0' -> mutableListOf<String>().apply {
            add(" " + "-".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + " ".repeat(s) + " ")
            repeat(s) { add("|" + " ".repeat(s) + "|") }
            add(" " + "-".repeat(s) + " ")
        }
        else -> throw Exception("Error")
    }
    return list[row]
}