package boj.Depth_first_Search.팀프로젝트9466

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val numList = readLine().split(" ").map { it.toInt() }.toMutableList()
        numList.add(0, 0)
        val visited = BooleanArray(n + 1)
        var result = 0
        for (i in 1 until n + 1) {
            if (!visited[i]) {
                val cycle = mutableListOf<Int>()
                result += dfs(i, numList, cycle, visited)
            }
        }
        println(result)
    }
    close()
}

private fun dfs(i: Int, numList: List<Int>, cycle: MutableList<Int>, visited: BooleanArray): Int {
    visited[i] = true
    cycle.add(i)

    val next = numList[i]
    if (visited[next]) {
        visited[next] = true
        return if (next in cycle) {
            cycle.indexOf(next)
        } else {
            cycle.size
        }
    }

    return dfs(numList[i], numList, cycle, visited)
}