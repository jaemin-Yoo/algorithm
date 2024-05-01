package boj.dijkstra.레이저통신6087

/**
 * 문제 번호: (6087)
 * 문제 이름: (레이저 통신)
 * 소요 시간(분): (x)
 */

import java.util.PriorityQueue

enum class Direction {
    NONE, START, END, TOP, BOTTOM
}

data class Position(
    val x: Int,
    val y: Int
)

data class Node(
    val pos: Position,
    val distance: Int,
    val direction: Direction
)

private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, 1, -1)
private val dd = listOf(Direction.TOP, Direction.BOTTOM, Direction.END, Direction.START)

fun main() = System.`in`.bufferedReader().use { br ->
    val (w, h) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array(h) { CharArray(w) }
    val distances = Array(h) { IntArray(w) { Int.MAX_VALUE } }
    val directionVisited = Array(h) { Array(w) { BooleanArray(Direction.values().size) } }
    repeat(h) { i ->
        val row = br.readLine().toCharArray()
        graph[i] = row
    }
    val (start, end) = laserPosition(graph, w, h)
    dijkstra(graph, distances, directionVisited, w, h, start)
    println(distances[end.x][end.y])
}

private fun laserPosition(graph: Array<CharArray>, w: Int, h: Int): MutableList<Position> {
    val posList = mutableListOf<Position>()
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (graph[i][j] == 'C') {
                posList.add(Position(i, j))
            }
        }
    }
    return posList
}

private fun dijkstra(graph: Array<CharArray>, distances: Array<IntArray>, directionVisited: Array<Array<BooleanArray>>, w: Int, h: Int, start: Position) {
    val pq = PriorityQueue<Node> { a, b -> a.distance - b.distance }
    pq.add(Node(start, 0, Direction.NONE))
    distances[start.x][start.y] = 0

    while (pq.isNotEmpty()) {
        val (pos, dist, d) = pq.poll()
        if (distances[pos.x][pos.y] < dist) continue

        for (i in 0 until 4) {
            val a = pos.x + dx[i]
            val b = pos.y + dy[i]
            val direction = dd[i]
            if (a in 0 until h && b in 0 until w && graph[a][b] != '*') {
                val newDist = if (d == Direction.NONE || d == direction) dist else dist + 1
                if (distances[a][b] > newDist || (distances[a][b] == newDist && !directionVisited[a][b][direction.ordinal])) {
                    distances[a][b] = newDist
                    directionVisited[a][b][direction.ordinal] = true
                    pq.add(Node(Position(a, b), newDist, direction))
                }
            }
        }
    }
}