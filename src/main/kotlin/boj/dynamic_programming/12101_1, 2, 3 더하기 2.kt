package boj.dynamic_programming

/**
 * 문제 번호: (12101)
 * 문제 이름: (1, 2, 3 더하기 2)
 * 소요 시간(분): (12)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val dp = Array(11) { listOf<String>() }
    dp[1] = listOf("1")
    dp[2] = listOf("1+1", "2")
    dp[3] = listOf("1+1+1", "1+2", "2+1", "3")
    for (i in 4 until 11) {
        val lst = mutableListOf<String>()
        for (j in 1..3) {
            dp[i - j].forEach { s ->
                val sb = StringBuilder(s)
                sb.append("+$j")
                lst.add(sb.toString())
            }
        }
        dp[i] = lst.sorted()
    }
    if (k - 1 < dp[n].size) {
        print(dp[n][k - 1])
    } else {
        print(-1)
    }
}