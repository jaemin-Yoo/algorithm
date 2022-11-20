package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val h = Array(n) { LongArray(n) }
    repeat(n) { idx ->
        val list = readLine().split(" ").map { it.toLong() }
        for (i in 0 until n) {
            h[idx][i] = list[i]
        }
    }

    val r = m / 2
    val ps = Array(n) { LongArray(n) }
    for (i in r until n - r) {
        for (j in r until n - r) {
            ps[i][j] = h[i - r][j - r]
            if (i - r - 1 >= 0)
                ps[i][j] -= h[i - r - 1][j - r]
            if (j - r - 1 >= 0)
                ps[i][j] -= h[i - r][j - r - 1]
            if (i - r - 1 >= 0 && j - r - 1 >= 0)
                ps[i][j] += h[i - r - 1][j - r - 1]
            if (i - m >= 0)
                ps[i][j] += ps[i - m][j]
            if (j - m >= 0)
                ps[i][j] += ps[i][j - m]
            if (i - m >= 0 && j - m >= 0)
                ps[i][j] -= ps[i - m][j - m]
        }
    }

    ps.forEach { arr ->
        val row = arr.map { it * -1 }
        println(row.joinToString(" "))
    }

    close()
}