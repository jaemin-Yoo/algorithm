package boj.Greedy

import java.util.Collections.min

fun main() {
    val n = readln().toInt()
    val balls = readln().toList()
    val result = min(
        listOf(
            getMoveCount(balls, 'R'),
            getMoveCount(balls.reversed(), 'R'),
            getMoveCount(balls, 'B'),
            getMoveCount(balls.reversed(), 'B')
        )
    )
    println(result)
}

private fun getMoveCount(balls: List<Char>, color: Char): Int {
    var cnt = 0
    var start = false

    for (ball in balls) {
        if (ball == color) {
            if (start) {
                cnt += 1
            }
        } else {
            start = true
        }
    }

    return cnt
}