package boj.data_structures

/**
 * 문제 번호: (7785)
 * 문제 이름: (회사에 있는 사람)
 * 소요 시간(분): (7)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val set = mutableSetOf<String>()
    val map = HashMap<String, String>()
    repeat(n) {
        val (name, state) = readLine().split(" ")
        map[name] = state
    }
    val workers = mutableListOf<String>()
    for ((k, v) in map) {
        if (v == "enter") {
            workers.add(k)
        }
    }
    workers.sortDescending()
    workers.forEach {
        println(it)
    }
    close()
}