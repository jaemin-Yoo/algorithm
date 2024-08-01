package boj.greedy

/**
 * 문제 번호: (17615)
 * 문제 이름: (볼 모으기)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val balls = br.readLine().toCharArray()
    val rStart = balls.indexOfFirst { it == 'R' }
    val bStart = balls.indexOfFirst { it == 'B' }
    val rEnd = balls.indexOfLast { it == 'R' }
    val bEnd = balls.indexOfLast { it == 'B' }
    val result = listOf(
        countLeftBall(balls, n, bStart, 'R'),
        countRightBall(balls, n, bEnd, 'R'),
        countLeftBall(balls, n, rStart, 'B'),
        countRightBall(balls, n, rEnd, 'B')
    ).min()
    println(result)
}

private fun countLeftBall(balls: CharArray, n: Int, start: Int, color: Char): Int {
    var cnt = 0
    for (i in start + 1 until n) {
        if (balls[i] == color) {
            cnt++
        }
    }
    return cnt
}

private fun countRightBall(balls: CharArray, n: Int, end: Int, color: Char): Int {
    var cnt = 0
    for (i in end - 1 downTo 0) {
        if (balls[i] == color) {
            cnt++
        }
    }
    return cnt
}