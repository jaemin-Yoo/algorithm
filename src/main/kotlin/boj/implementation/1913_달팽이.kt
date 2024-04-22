package boj.implementation

/**
 * 문제 번호: (1913)
 * 문제 이름: (달팽이)
 * 소요 시간(분): (19)
 */

private val dx = listOf(1, 0, -1, 0)
private val dy = listOf(0, 1, 0, -1)

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    var x = 0
    var y = 0
    var d = 0
    var v = n * n
    val graph = Array(n) { IntArray(n) }
    var c = 1 to 1
    while (v > 0) {
        graph[x][y] = v--
        val a = x + dx[d]
        val b = y + dy[d]
        if (a in 0 until n && b in 0 until n && graph[a][b] == 0) {
            x = a
            y = b
        } else {
            d = (d + 1) % 4
            x += dx[d]
            y += dy[d]
        }

        if (v == k) {
            c = x + 1 to y + 1
        }
    }
    graph.forEach {
        println(it.joinToString(" "))
    }
    println("${c.first} ${c.second}")
}