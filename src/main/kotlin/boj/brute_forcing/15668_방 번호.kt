package boj.brute_forcing

/**
 * 문제 번호: (15668)
 * 문제 이름: (방 번호)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var result = "-1"
    for (a in 1 until 87654) {
        val b = n - a
        if (b <= 0) break

        if (isNotDistinct(a, b)) {
            result = "$a + $b"
            break
        }
    }
    println(result)
    close()
}

private fun isNotDistinct(a: Int, b: Int): Boolean {
    val list = (a.toString() + b.toString()).toList()
    return list.size == list.distinct().size
}