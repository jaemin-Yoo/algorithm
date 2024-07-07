package boj.implementation

/**
 * 문제 번호: (2563)
 * 문제 이름: (색종이)
 * 소요 시간(분): (8)
 */

private const val MAX_SIZE = 100

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val graph = Array(MAX_SIZE) { BooleanArray(MAX_SIZE) }
    repeat(n) {
        val (x, y) = br.readLine().split(' ').map { it.toInt() }
        for (i in x - 1 until x + 9) {
            for (j in y - 1 until y + 9) {
                graph[i][j] = true
            }
        }
    }

    var cnt = 0
    for (i in 0 until MAX_SIZE) {
        for (j in 0 until MAX_SIZE) {
            if (graph[i][j]) {
                cnt++
            }
        }
    }
    println(cnt)
}