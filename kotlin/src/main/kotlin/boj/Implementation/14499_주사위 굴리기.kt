package boj.Implementation.주사위굴리기14499

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, _x, _y, k) = readLine().split(" ").map { it.toInt() }
    var (x, y) = _x to _y
    val graph = mutableListOf<MutableList<Int>>()
    val dice = Array(6) { 0 }
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }.toMutableList()
        graph.add(row)
    }

    val cmdList = readLine().split(" ").map { it.toInt() }
    cmdList.forEach { cmd ->
        when (cmd) {
            1 -> {
                if (x in 0 until n && y + 1 in 0 until m) {
                    y += 1
                } else {
                    return@forEach
                }

                val temp = dice.toIntArray()
                dice[1] = temp[3]
                dice[2] = temp[1]
                dice[3] = temp[4]
                dice[4] = temp[2]
            }
            2 -> {
                if (x in 0 until n && y - 1 in 0 until m) {
                    y -= 1
                } else {
                    return@forEach
                }

                val temp = dice.toIntArray()
                dice[1] = temp[2]
                dice[2] = temp[4]
                dice[3] = temp[1]
                dice[4] = temp[3]
            }
            3 -> {
                if (x - 1 in 0 until n && y in 0 until m) {
                    x -= 1
                } else {
                    return@forEach
                }

                val temp = dice.toIntArray()
                dice[0] = temp[1]
                dice[1] = temp[5]
                dice[4] = temp[0]
                dice[5] = temp[4]
            }
            4 -> {
                if (x + 1 in 0 until n && y in 0 until m) {
                    x += 1
                } else {
                    return@forEach
                }

                val temp = dice.toIntArray()
                dice[0] = temp[4]
                dice[1] = temp[0]
                dice[4] = temp[5]
                dice[5] = temp[1]
            }
        }

        if (graph[x][y] == 0) {
            graph[x][y] = dice[4]
        } else {
            dice[4] = graph[x][y]
            graph[x][y] = 0
        }
        println(dice[1])
    }

    close()
}