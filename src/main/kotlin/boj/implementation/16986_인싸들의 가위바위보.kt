package boj.implementation

/**
 * 문제 번호: (16986)
 * 문제 이름: (인싸들의 가위바위보)
 * 소요 시간(분): (x)
 */

import java.util.Queue
import java.util.LinkedList
import kotlin.math.pow

enum class Player {
    A, B, C
}

data class Node(
    val p1: Player,
    val p2: Player,
    val aCount: Int,
    val bCount: Int,
    val cCount: Int,
    val bRound: Int,
    val cRound: Int,
    val visited: Int
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val graph = mutableListOf<List<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }
        graph.add(row)
    }
    val b = readLine().split(" ").map { it.toInt() }
    val c = readLine().split(" ").map { it.toInt() }

    val result = bfs(graph, b, c, n, k)
    println(result)

    close()
}

private fun bfs(graph: MutableList<List<Int>>, b: List<Int>, c: List<Int>, n: Int, k: Int): Int {
    val q: Queue<Node> = LinkedList()
    q.add(Node(Player.A, Player.B, 0, 0, 0, 0, 0, 0))

    while (q.isNotEmpty()) {
        val (p1, p2, aCount, bCount, cCount, bRound, cRound, visited) = q.poll()
        println(
            """
                p1: $p1
                p2: $p2
                aCount: $aCount
                bCount: $bCount
                cCount: $cCount
                bRound: $bRound
                cRound: $cRound
                visited: $visited
            """.trimIndent()
        )
        println()
        if (bCount == k || cCount == k) {
            continue
        } else if (aCount == k) {
            return 1
        }

        if (p1 == Player.A && p2 == Player.B) {
            val x = b[bRound]
            for (i in 0 until n) {
                if (visited and i > 0) continue

                val v = visited + 2.0.pow(i).toInt()
                when (graph[i][x - 1]) {
                    0 -> q.add(Node(Player.B, Player.C, aCount, bCount + 1, cCount, bRound + 1, cRound, v))
                    1 -> q.add(Node(Player.B, Player.C, aCount, bCount + 1, cCount, bRound + 1, cRound, v))
                    2 -> q.add(Node(Player.A, Player.C, aCount + 1, bCount, cCount, bRound + 1, cRound, v))
                }
            }
        } else if (p1 == Player.A && p2 == Player.C) {
            val x = c[cRound]
            for (i in 0 until n) {
                if (visited and i > 0) continue

                val v = visited + 2.0.pow(i).toInt()
                when (graph[i][x - 1]) {
                    0 -> q.add(Node(Player.B, Player.C, aCount, bCount, cCount + 1, bRound, cRound + 1, v))
                    1 -> q.add(Node(Player.B, Player.C, aCount, bCount, cCount + 1, bRound, cRound + 1, v))
                    2 -> q.add(Node(Player.A, Player.B, aCount + 1, bCount, cCount, bRound, cRound + 1, v))
                }
            }
        } else if (p1 == Player.B && p2 == Player.C) {
            val x = b[bRound]
            val y = c[cRound]
            when (graph[x - 1][y - 1]) {
                0 -> q.add(Node(Player.A, Player.C, aCount, bCount, cCount + 1, bRound + 1, cRound + 1, visited))
                1 -> q.add(Node(Player.A, Player.C, aCount, bCount, cCount + 1, bRound + 1, cRound + 1, visited))
                2 -> q.add(Node(Player.A, Player.B, aCount, bCount + 1, cCount, bRound + 1, cRound + 1, visited))
            }
        }
    }

    return 0
}

/*

방문 안한 노드 중 2 찾기.

1. 그냥 무조건 이기면 됨
2. 지는 경우 아무거나 내면 됨
3.

- 모든 경우의 수 확인
- visited는 비트마스킹
- 큐에 삽입
-

 */