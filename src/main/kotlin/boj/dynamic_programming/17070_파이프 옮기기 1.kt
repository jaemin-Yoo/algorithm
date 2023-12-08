package boj.dynamic_programming

/**
 * 문제 번호: (17070)
 * 문제 이름: (파이프 옮기기 1)
 * 소요 시간(분): (x)
 */

private const val EMPTY_ROOM = 0
private const val WALL = 1

private const val HORIZONTAL = 0
private const val VERTICAL = 1
private const val DIAGONAL = 2

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = Array(n + 1) { IntArray(n + 1) }
    val dp = Array(n + 1) { Array(n + 1) { IntArray(3) } }

    for (i in 1 until n + 1) {
        val row = readLine().split(" ").map{ it.toInt() }
        for (j in 1 until n + 1) {
            graph[i][j] = row[j - 1]
        }
    }

    initDpArray(n, dp, graph)

    for (i in 2 until n + 1) {
        for (j in 2 until n + 1) {
            if (graph[i][j] == WALL) continue

            dp[i][j][HORIZONTAL] = dp[i][j - 1][HORIZONTAL] + dp[i][j - 1][DIAGONAL]
            dp[i][j][VERTICAL] = dp[i - 1][j][VERTICAL] + dp[i - 1][j][DIAGONAL]

            if (graph[i][j - 1] == EMPTY_ROOM && graph[i - 1][j] == EMPTY_ROOM) {
                dp[i][j][DIAGONAL] = dp[i - 1][j - 1][HORIZONTAL] + dp[i - 1][j - 1][VERTICAL] + dp[i - 1][j - 1][DIAGONAL]
            }
        }
    }

    println(dp[n][n].sum())
    close()
}

private fun initDpArray(n: Int, dp: Array<Array<IntArray>>, graph: Array<IntArray>) {
    for (j in 2 until n + 1) {
        if (graph[1][j] == WALL) break

        dp[1][j][HORIZONTAL] = 1
    }
}