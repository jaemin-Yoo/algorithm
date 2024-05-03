package boj.binary_search

/**
 * 문제 번호: (13702)
 * 문제 이름: (이상한 술집)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val cs = mutableListOf<Int>()
    repeat(n) {
        val c = br.readLine().toInt()
        cs.add(c)
    }
    val result = binarySearch(cs, k)
    println(result)
}

private fun binarySearch(cs: MutableList<Int>, target: Int): Long {
    var start = 0L
    var end = cs.maxOf { it }.toLong()
    var result = 0L
    while (start <= end) {
        val mid = (start + end) / 2
        if (mid == 0L) {
            start = mid + 1
            continue
        }

        var cnt = 0L
        cs.forEach { c ->
            cnt += c / mid
        }
        if (cnt >= target) {
            result = mid
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return result
}