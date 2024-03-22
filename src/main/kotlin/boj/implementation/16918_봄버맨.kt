package boj.implementation

/**
 * 문제 번호: (16918)
 * 문제 이름: (봄버맨)
 * 소요 시간(분): (x)
 */

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, n) = readLine().split(" ").map { it.toInt() }
    val board = Array(r) { CharArray(c) }
    repeat(r) {
        val row = readLine()
        board[it] = row.toCharArray()
    }
    val aBoard = board
    val bBoard = otherBoard(board, r, c)
    val cBoard = Array(r) { CharArray(c) { 'O' } }
    val dBoard = otherBoard(bBoard, r, c)
    val result = if (n == 1) {
        aBoard
    } else if (n % 2 == 0) {
        cBoard
    } else if (n % 4 == 3) {
        bBoard
    } else {
        dBoard
    }
    result.forEach {
        println(it.joinToString(""))
    }
    close()
}

private fun otherBoard(board: Array<CharArray>, r: Int, c: Int): Array<CharArray> {
    val newBoard = Array(r) { CharArray(c) { 'O' } }
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (board[i][j] == 'O') {
                for (k in 0 until 4) {
                    val x = dx[k] + i
                    val y = dy[k] + j
                    if (x in 0 until r && y in 0 until c) {
                        newBoard[x][y] = '.'
                    }
                }
                newBoard[i][j] = '.'
            }
        }
    }
    return newBoard
}