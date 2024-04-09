package boj.dynamic_programming

/**
 * 문제 번호: (10164)
 * 문제 이름: (격자상의 경로)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m, k) = br.readLine().split(' ').map { it.toInt() }
    val dp = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        dp[i][0] = 1
    }
    for (j in 0 until m) {
        dp[0][j] = 1
    }

    val result = if (k == 0) {
        for (i in 1 until n) {
            for (j in 1 until m) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        dp[n - 1][m - 1]
    } else {
        val (x, y) = getKPosition(n, m, k)
        for (i in 1 until x + 1) {
            for (j in 1 until y + 1) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        for (i in x until n) {
            dp[i][y] = dp[x][y]
        }
        for (j in y until m) {
            dp[x][j] = dp[x][y]
        }

        for (i in x + 1 until n) {
            for (j in y + 1 until m) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        dp[n - 1][m - 1]
    }
    println(result)
}

private fun getKPosition(n: Int, m: Int, k: Int): Pair<Int, Int> {
    if (k == 0) {
        return n - 1 to m - 1
    }

    var num = 1
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (num++ == k) {
                return i to j
            }
        }
    }

    throw Exception("k값이 Graph 칸의 개수를 넘어갑니다.")
}