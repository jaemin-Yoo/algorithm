package boj.dynamic_programming

/**
 * 문제 번호: (14501)
 * 문제 이름: (퇴사)
 * 소요 시간(분): (30)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    val days = IntArray(n + 1)
    val amount = IntArray(n + 1)
    repeat(n) { i ->
        val (t, p) = br.readLine().split(' ').map { it.toInt() }
        days[i + 1] = t
        amount[i + 1] = p
    }

    for (i in n downTo 1) {
        val day = i + days[i]
        if (day == n + 1) {
            dp[i] = amount[i]
        } else if (day <= n) {
            dp[i] = amount[i] + dp.copyOfRange(day, n + 1).max()
        }
    }
    println(dp.maxOf { it })
}