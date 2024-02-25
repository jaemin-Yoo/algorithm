package boj.union_find

/**
 * 문제 번호: (17352)
 * 문제 이름: (여러분의 다리가 되어 드리겠습니다!)
 * 소요 시간(분): (15)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val parents = IntArray(n + 1) { it }
    repeat(n - 2) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        unionParent(parents, a, b)
    }
    val x = getParent(parents, 1)
    for (i in 2 until n + 1) {
        val y = getParent(parents, i)
        if (x != y) {
            println("$x $y")
            break
        }
    }
    close()
}

private fun getParent(parents: IntArray, x: Int): Int {
    if (parents[x] == x) return x

    parents[x] = getParent(parents, parents[x])
    return parents[x]
}

private fun unionParent(parents: IntArray, x: Int, y: Int) {
    val a = getParent(parents, x)
    val b = getParent(parents, y)
    if (a < b) {
        parents[b] = a
    } else {
        parents[a] = b
    }
}