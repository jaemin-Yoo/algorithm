package boj.greedy

/**
 * 문제 번호: (14916)
 * 문제 이름: (거스름돈)
 * 소요 시간(분): (10)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val result = getMinCount(n)
    print(result)
}

private fun getMinCount(n: Int): Int {
    var result = 0
    var q = n / 5
    var r = n % 5
    while (r % 2 != 0) {
        q--
        if (q < 0) {
            return -1
        }
        r = n - q * 5
    }
    result += q
    result += r / 2

    return result
}