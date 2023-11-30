package programmers.카카오인턴십2020.경주로건설

// 1시간

import java.util.Queue
import java.util.LinkedList

class Solution {

    private val dx = listOf(1, -1, 0, 0)
    private val dy = listOf(0, 0, 1, -1)
    private val d = listOf(Direction.BOTTOM, Direction.TOP, Direction.RIGHT, Direction.LEFT)

    private var n = 0

    fun solution(board: Array<IntArray>): Int {
        n = board.size
        bfs(Position(0, 0, Direction.NONE, 0), board)
        return board[n - 1][n - 1]
    }

    private fun bfs(start: Position, board: Array<IntArray>) {
        val q: Queue<Position> = LinkedList()
        q.add(start)
        board[start.x][start.y] = 1

        while (q.isNotEmpty()) {
            val (x, y, preDirection, price) = q.poll()
            for (i in 0 until 4) {
                val a = x + dx[i]
                val b = y + dy[i]
                val newPrice = if (d[i] == preDirection || preDirection == Direction.NONE) {
                    price + 100
                } else {
                    price + 600
                }
                val nextA = a + dx[i]
                val nextB = b + dy[i]
                val nextPrice = newPrice + 100

                if (a in 0 until n && b in 0 until n && board[a][b] != 1 && (board[a][b] == 0 || board[a][b] >= newPrice || (nextA in 0 until n && nextB in 0 until n && board[nextA][nextB] != 1 && board[nextA][nextB] >= nextPrice))) {
                    board[a][b] = newPrice
                    q.add(Position(a, b, d[i], newPrice))
                }
            }
        }
    }

    data class Position(
        val x: Int,
        val y: Int,
        val preDirection: Direction,
        val price: Int
    )

    enum class Direction {
        NONE, TOP, BOTTOM, LEFT, RIGHT
    }
}