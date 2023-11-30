package boj.Data_Structures.집합의표현1717

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val parents = Array(n + 1) { it }
    repeat(m) {
        val (k, a, b) = readLine().split(" ").map { it.toInt() }
        if (k == 0) {
            unionParent(parents, a, b)
        } else {
            val result = if (isSameParent(parents, a, b)) {
                "YES"
            } else {
                "NO"
            }
            println(result)
        }
    }

    close()
}

fun getParent(parents: Array<Int>, a: Int): Int {
    if (parents[a] == a) {
        return a
    }

    parents[a] = getParent(parents, parents[a])
    return parents[a]
}

fun unionParent(parents: Array<Int>, a: Int, b: Int) {
    val x = getParent(parents, a)
    val y = getParent(parents, b)
    if (x < y) {
        parents[y] = x
    } else {
        parents[x] = y
    }
}

fun isSameParent(parents: Array<Int>, a: Int, b: Int): Boolean {
    val x = getParent(parents, a)
    val y = getParent(parents, b)
    return x == y
}