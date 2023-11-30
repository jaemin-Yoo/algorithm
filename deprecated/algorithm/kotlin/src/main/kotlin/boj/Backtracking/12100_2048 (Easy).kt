package boj.Backtracking.Easy204812100

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = mutableListOf<MutableList<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }.toMutableList()
        graph.add(row)
    }

    var maxSizeBlock = 0
    for (d1 in Direction.values()) {
        val graph1 = graph.map { it.toMutableList() }.toMutableList()
        solve(n, graph1, d1)
        for (d2 in Direction.values()) {
            val graph2 = graph1.map { it.toMutableList() }.toMutableList()
            solve(n, graph2, d2)
            for (d3 in Direction.values()) {
                val graph3 = graph2.map { it.toMutableList() }.toMutableList()
                solve(n, graph3, d3)
                for (d4 in Direction.values()) {
                    val graph4 = graph3.map { it.toMutableList() }.toMutableList()
                    solve(n, graph4, d4)
                    for (d5 in Direction.values()) {
                        val graph5 = graph4.map { it.toMutableList() }.toMutableList()
                        solve(n, graph5, d5)

                        graph5.forEach { row ->
                            maxSizeBlock = max(maxSizeBlock, row.maxOf { it })
                        }
                    }
                }
            }
        }
    }

    println(maxSizeBlock)

    close()
}

private fun solve(n: Int, graph: MutableList<MutableList<Int>>, direction: Direction) {
    for (i in 0 until n) {
        combineBlock(n, graph, direction, i)
        moveBlock(n, graph, direction, i)
    }
}

private fun combineBlock(n: Int, graph: MutableList<MutableList<Int>>, direction: Direction, line: Int) {
    // Top, Bottom -> y축 = line,
    // Start, End -> x축 = line
    // Top, Start -> 0 ~ n - 1
    // Bottom, End -> n - 1 ~ 0

    when (direction) {
        Direction.TOP -> {
            for (i in 0 until n - 1) {
                if (graph[i][line] == 0) continue

                for (j in i + 1 until n) {
                    if (graph[j][line] == 0) continue

                    if (graph[i][line] == graph[j][line]) {
                        graph[i][line] *= 2
                        graph[j][line] = 0
                    }
                    break
                }
            }
        }
        Direction.BOTTOM -> {
            for (i in n - 1 downTo 1) {
                if (graph[i][line] == 0) continue

                for (j in i - 1 downTo 0) {
                    if (graph[j][line] == 0) continue

                    if (graph[i][line] == graph[j][line]) {
                        graph[i][line] *= 2
                        graph[j][line] = 0
                    }
                    break
                }
            }
        }
        Direction.START -> {
            for (i in 0 until n - 1) {
                if (graph[line][i] == 0) continue

                for (j in i + 1 until n) {
                    if (graph[line][j] == 0) continue

                    if (graph[line][i] == graph[line][j]) {
                        graph[line][i] *= 2
                        graph[line][j] = 0
                    }
                    break
                }
            }
        }
        Direction.END -> {
            for (i in n - 1 downTo 1) {
                if (graph[line][i] == 0) continue

                for (j in i - 1 downTo 0) {
                    if (graph[line][j] == 0) continue

                    if (graph[line][i] == graph[line][j]) {
                        graph[line][i] *= 2
                        graph[line][j] = 0
                    }
                    break
                }
            }
        }
    }
}

private fun moveBlock(n: Int, graph: MutableList<MutableList<Int>>, direction: Direction, line: Int) {
    when (direction) {
        Direction.TOP -> {
            for (i in 0 until n) {
                if (graph[i][line] == 0) {
                    for (j in i + 1 until n) {
                        if (graph[j][line] != 0) {
                            graph[i][line] = graph[j][line]
                            graph[j][line] = 0
                            break
                        }
                    }
                }
            }
        }
        Direction.BOTTOM -> {
            for (i in n - 1 downTo 0) {
                if (graph[i][line] == 0) {
                    for (j in i - 1 downTo  0) {
                        if (graph[j][line] != 0) {
                            graph[i][line] = graph[j][line]
                            graph[j][line] = 0
                            break
                        }
                    }
                }
            }
        }
        Direction.START -> {
            for (i in 0 until n) {
                if (graph[line][i] == 0) {
                    for (j in i + 1 until n) {
                        if (graph[line][j] != 0) {
                            graph[line][i] = graph[line][j]
                            graph[line][j] = 0
                            break
                        }
                    }
                }
            }
        }
        Direction.END -> {
            for (i in n - 1 downTo 0) {
                if (graph[line][i] == 0) {
                    for (j in i - 1 downTo  0) {
                        if (graph[line][j] != 0) {
                            graph[line][i] = graph[line][j]
                            graph[line][j] = 0
                            break
                        }
                    }
                }
            }
        }
    }
}

enum class Direction {
    TOP, BOTTOM, START, END
}