package boj.hashing

/**
 * 문제 번호: (1351)
 * 문제 이름: (무한 수열)
 * 소요 시간(분): (17)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, p, q) = readLine().split(" ").map { it.toLong() }
    val result = solve(n, p, q, HashMap())
    println(result)
    close()
}

private fun solve(n: Long, p: Long, q: Long, map: HashMap<Long, Long>): Long {
    if (n == 0L) {
        return 1
    }

    val ans = if (map.containsKey(n)) {
        map[n]!!
    } else {
        val sum = solve(n / p, p, q, map) + solve(n / q, p, q, map)
        map[n] = sum
        sum
    }
    return ans
}