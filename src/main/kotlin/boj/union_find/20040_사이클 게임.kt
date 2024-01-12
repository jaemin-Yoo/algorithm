package boj.union_find

/**
 * 문제 번호: (20040)
 * 문제 이름: (사이클 게임)
 * 소요 시간(분): (36)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val parent = IntArray(n) { it }
    var result = 0
    for (i in 0 until m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        if (isSameParent(parent, a, b)) {
            result = i + 1
            break
        }
        unionParent(parent, a, b)
    }
    println(result)
    close()
}

private fun getParent(parent: IntArray, x: Int): Int {
    if (parent[x] == x) return x

    parent[x] = getParent(parent, parent[x])
    return parent[x]
}

private fun unionParent(parent: IntArray, x: Int, y: Int) {
    val a = getParent(parent, x)
    val b = getParent(parent, y)
    if (a > b) {
        parent[a] = b
    } else {
        parent[b] = a
    }
}

private fun isSameParent(parent: IntArray, x: Int, y: Int): Boolean {
    val a = getParent(parent, x)
    val b = getParent(parent, y)
    return a == b
}