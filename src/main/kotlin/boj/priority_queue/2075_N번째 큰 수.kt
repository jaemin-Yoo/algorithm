package boj.priority_queue

/**
 * 문제 번호: (2075)
 * 문제 이름: (N번째 큰 수)
 * 소요 시간(분): (3)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val lst = mutableListOf<Int>()
    repeat(n) {
        val row = br.readLine().split(' ').map { it.toInt() }
        lst.addAll(row)
    }
    lst.sortDescending()
    println(lst[n - 1])
}