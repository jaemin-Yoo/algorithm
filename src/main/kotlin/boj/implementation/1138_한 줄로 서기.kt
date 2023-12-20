package boj.implementation

/**
 * 문제 번호: (1138)
 * 문제 이름: (한 줄로 서기)
 * 소요 시간(분): (8)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }

    val order = mutableListOf<Int>()
    for (i in n - 1 downTo 0) {
        val idx = list[i]
        if (idx == order.size) {
            order.add(i + 1)
        } else {
            order.add(idx, i + 1)
        }
    }
    println(order.joinToString(" "))

    close()
}