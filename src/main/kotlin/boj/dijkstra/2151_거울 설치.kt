package boj.dijkstra.거울설치2151

/**
 * 문제 번호: (2151)
 * 문제 이름: (거울 설치)
 * 소요 시간(분): (x)
 */

import java.util.PriorityQueue

private enum class Direction {
    NONE, START, END, TOP, BOTTOM
}

private data class Position(
    val x: Int,
    val y: Int
)

private data class Node(
    val pos: Position,
    val dist: Int,
    val direction: Direction
)

private val dx = listOf(1, 0, -1, 0)
private val dy = listOf(0, 1, 0, -1)
private val dd = listOf(Direction.BOTTOM, Direction.END, Direction.TOP, Direction.START)

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val graph = Array(n) { CharArray(n) }
    val distances = Array(n) { Array(n) { IntArray(4) { Int.MAX_VALUE } } }
    repeat(n) { i ->
        val row = br.readLine().toCharArray()
        graph[i] = row
    }

    val (start, end) = getDoorPosition(graph, n)
    dijkstra(graph, distances, start, end, n)
    println(distances[end.x][end.y].minOf { it })
}

private fun getDoorPosition(graph: Array<CharArray>, n: Int): MutableList<Position> {
    val position = mutableListOf<Position>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == '#') {
                position.add(Position(i, j))
            }
        }
    }
    return position
}

private fun dijkstra(graph: Array<CharArray>, distances: Array<Array<IntArray>>, start: Position, end: Position, n: Int) {
    val pq = PriorityQueue<Node> { a, b -> a.dist - b.dist }
    pq.add(Node(start, 0, Direction.NONE))
    for (i in 0 until 4) {
        distances[start.x][start.y][i] = 0
    }

    while (pq.isNotEmpty()) {
        val (pos, dist, direction) = pq.poll()
        if (indexOfDirection(direction) != -1 && distances[pos.x][pos.y][indexOfDirection(direction)] < dist) continue

        if (graph[pos.x][pos.y] == '.') {
            val i = indexOfDirection(direction)
            val a = pos.x + dx[i]
            val b = pos.y + dy[i]
            if (a in 0 until n && b in 0 until n && graph[a][b] != '*') {
                if (distances[a][b][i] > dist) {
                    distances[a][b][i] = dist
                    pq.add(Node(Position(a, b), dist, dd[i]))
                }
            }
        } else {
            for (i in 0 until 4) {
                val a = pos.x + dx[i]
                val b = pos.y + dy[i]
                if (a in 0 until n && b in 0 until n && graph[a][b] != '*') {
                    if (direction == dd[(i + 2) % 4]) continue

                    val newDist = if (direction == Direction.NONE || dd[i] == direction) dist else dist + 1
                    if (distances[a][b][i] > newDist) {
                        distances[a][b][i] = newDist
                        pq.add(Node(Position(a, b), newDist, dd[i]))
                    }
                }
            }
        }
    }
}

private fun indexOfDirection(direction: Direction) = dd.indexOf(direction)