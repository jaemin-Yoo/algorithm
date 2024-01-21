package boj.greedy

/**
 * 문제 번호: (2141)
 * 문제 이름: (우체국)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val village = mutableListOf<Pair<Int, Int>>()
    var pCount = 0L
    repeat(n) {
        val (x, a) = readLine().split(" ").map { it.toInt() }
        village.add(x to a)
        pCount += a
    }
    village.sortBy { it.first }

    var cnt = 0L
    pCount = if (pCount % 2 != 0L) {
        pCount + 1
    } else {
        pCount
    }
    for ((x, a) in village) {
        cnt += a
        if (cnt >= pCount / 2) {
            println(x)
            break
        }
    }
    close()
}