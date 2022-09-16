package boj.Implementation

class 로봇청소기14503 {
    val direction = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
    val graph = mutableListOf<MutableList<Int>>()
    var cnt = 0
    var n = 0
    var m = 0
    fun main() {
        val (_n, _m) = readln().split(' ').map { it.toInt() }
        n = _n
        m = _m
        val (r, c, d) = readln().split(' ').map { it.toInt() }
        repeat(n) {
            graph.add(readln().split(' ').map { it.toInt() }.toMutableList())
        }
        solve(r, c, d)
        println(cnt)
    }

    fun solve(x: Int, y: Int, d: Int) {
        graph[x][y] = -1
        cnt += 1

        var robotX = x
        var robotY = y
        var robotD = d
        while (true) {
            for (i in 0 until 4) {
                robotD = (robotD + 3) % 4
                val state = check(robotX, robotY, robotD)?.let { (x, y) ->
                    robotX = x
                    robotY = y
                    true
                } ?: false

                if (state) {
                    break
                } else if (i == 3) {
                    val (dx, dy) = direction[(robotD + 2) % 4]
                    robotX += dx
                    robotY += dy

                    if (graph[robotX][robotY] == 1) return
                }
            }
        }
    }

    fun check(x: Int, y: Int, idx: Int): Pair<Int, Int>? {
        val (dx, dy) = direction[idx]
        val a = x + dx
        val b = y + dy
        if (a in 0 until n
            && b in 0 until m
            && graph[a][b] == 0) {
            graph[a][b] = -1
            cnt += 1
            return a to b
        }
        return null
    }
}