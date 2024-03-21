package boj.implementation

/**
 * 문제 번호: (2615)
 * 문제 이름: (오목)
 * 소요 시간(분): (x)
 */

private const val BOARD_SIZE = 19

fun main() = with(System.`in`.bufferedReader()) {
    val board = Array(BOARD_SIZE) { IntArray(BOARD_SIZE) }
    repeat(BOARD_SIZE) { i ->
        val row = readLine().split(" ").map { it.toInt() }.toIntArray()
        board[i] = row
    }
    for (i in 0 until BOARD_SIZE) {
        for (j in 0 until BOARD_SIZE) {
            if (board[i][j] != 0 && isWin(board, i, j)) {
                println(board[i][j])
                println("${i+1} ${j+1}")
                return@with
            }
        }
    }
    println(0)
    close()
}

private fun isWin(board: Array<IntArray>, x: Int, y: Int): Boolean {
    val color = board[x][y]
    var cnt = 0
    for (k in -1 until 6) {
        val a = x + k
        val b = y
        if (a in 0 until BOARD_SIZE && b in 0 until BOARD_SIZE) {
            if ((k == -1 && board[a][b] == color) || (k == 5 && board[a][b] == color)) {
                cnt = 0
                break
            }

            if (board[a][b] == color) {
                cnt++
            }
        }
    }
    if (cnt == 5) return true

    cnt = 0
    for (k in -1 until 6) {
        val a = x
        val b = y + k
        if (a in 0 until BOARD_SIZE && b in 0 until BOARD_SIZE) {
            if ((k == -1 && board[a][b] == color) || (k == 5 && board[a][b] == color)) {
                cnt = 0
                break
            }

            if (board[a][b] == color) {
                cnt++
            }
        }
    }
    if (cnt == 5) return true

    cnt = 0
    for (k in -1 until 6) {
        val a = x + k
        val b = y + k
        if (a in 0 until BOARD_SIZE && b in 0 until BOARD_SIZE) {
            if ((k == -1 && board[a][b] == color) || (k == 5 && board[a][b] == color)) {
                cnt = 0
                break
            }

            if (board[a][b] == color) {
                cnt++
            }
        }
    }
    if (cnt == 5) return true

    cnt = 0
    for (k in -1 until 6) {
        val a = x - k
        val b = y + k
        if (a in 0 until BOARD_SIZE && b in 0 until BOARD_SIZE) {
            if ((k == -1 && board[a][b] == color) || (k == 5 && board[a][b] == color)) {
                cnt = 0
                break
            }

            if (board[a][b] == color) {
                cnt++
            }
        }
    }
    return cnt == 5
}