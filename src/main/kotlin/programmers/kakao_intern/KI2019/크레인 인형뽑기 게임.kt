package programmers.KI2019.크레인인형뽑기게임

// 26분

import java.util.Stack

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var result = 0
        val basket = Stack<Int>()

        moves.forEach { j ->
            for (i in 0 until board.size) {
                val doll = board[i][j - 1]
                if (doll > 0) {
                    board[i][j - 1] = 0
                    if (basket.isNotEmpty() && basket.peek() == doll) {
                        basket.pop()
                        result += 2
                    } else {
                        basket.add(doll)
                    }
                    break
                }
            }
        }

        return result
    }
}