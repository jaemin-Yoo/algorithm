package boj.implementation

/**
 * 문제 번호: (3758)
 * 문제 이름: (KCPC)
 * 소요 시간(분): (30)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val tc = br.readLine().toInt()
    repeat(tc) {
        val (n, k, t, m) = br.readLine().split(' ').map { it.toInt() }
        val scoreGraph = Array(n + 1) { IntArray(k + 1) }
        val submitCounts = IntArray(n + 1)
        val lastSubmitIndexes = IntArray(n + 1) { -1 }
        repeat(m) { submitIdx ->
            val (i, j, s) = br.readLine().split(' ').map { it.toInt() }
            if (scoreGraph[i][j] < s) {
                scoreGraph[i][j] = s
            }
            submitCounts[i]++
            lastSubmitIndexes[i] = submitIdx
        }
        var rank = 1
        val myScore = scoreGraph[t].sum()
        for (i in 1 until n + 1) {
            if (i == t) continue

            val score = scoreGraph[i].sum()
            if (myScore < score) {
                rank++
            } else if (myScore == score) {
                if (submitCounts[t] > submitCounts[i]) {
                    rank++
                } else if (submitCounts[t] == submitCounts[i]) {
                    if (lastSubmitIndexes[t] > lastSubmitIndexes[i]) {
                        rank++
                    }
                }
            }
        }
        println(rank)
    }
}