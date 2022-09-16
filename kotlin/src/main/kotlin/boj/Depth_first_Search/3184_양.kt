package boj.Depth_first_Search

class 양3184 {
    val graph = mutableListOf<MutableList<Char>>()
    var r = 0
    var c = 0
    fun main() {
        val (_r, _c) = readln().split(" ").map { it.toInt() }
        r = _r
        c = _c
        repeat(r) {
            graph.add(readln().toMutableList())
        }

        var oCnt = 0
        var vCnt = 0
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (graph[i][j] != '#') {
                    val (o, v) = dfs(i, j, 0, 0)
                    if (o <= v) {
                        vCnt += v
                    } else {
                        oCnt += o
                    }
                }
            }
        }
        println("$oCnt $vCnt")
    }

    fun dfs(x: Int, y: Int, oCnt: Int, vCnt: Int): Pair<Int, Int> {
        var o = oCnt
        var v = vCnt

        if (x !in 0 until r
            || y !in 0 until c
        ) {
            return o to v
        }

        when (graph[x][y]) {
            'o' -> o += 1
            'v' -> v += 1
            '#' -> return o to v
        }

        graph[x][y] = '#'

        var cnt = o to v
        cnt = dfs(x + 1, y, cnt.first, cnt.second)
        cnt = dfs(x - 1, y, cnt.first, cnt.second)
        cnt = dfs(x, y + 1, cnt.first, cnt.second)
        cnt = dfs(x, y - 1, cnt.first, cnt.second)
        return cnt
    }
}