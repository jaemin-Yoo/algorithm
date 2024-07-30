package boj.backtracking

/**
 * 문제 번호: (9663)
 * 문제 이름: (N-Queen)
 * 소요 시간(분): (x)
 */

import kotlin.math.abs

private var cnt = 0

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val row = IntArray(n)
    nQueen(row, n, 0)
    println(cnt)
}

private fun nQueen(row: IntArray, n: Int, x: Int) {
    if (x == n) {
        cnt++
        return
    }

    for (y in 0 until n) {
        if (promising(row, x, y)) {
            row[x] = y
            nQueen(row, n, x + 1)
        }
    }
}

private fun promising(row: IntArray, x: Int, y: Int): Boolean {
    for (i in 0 until x) {
        if (y == row[i] || abs(y - row[i]) == abs(x - i)) {
            return false
        }
    }
    return true
}