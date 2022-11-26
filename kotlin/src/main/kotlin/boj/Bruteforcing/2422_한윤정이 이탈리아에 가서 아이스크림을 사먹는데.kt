package boj.Bruteforcing.한윤정

private var count = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (i in 1..n) {
        map[i] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        map[a]!!.add(b)
    }


    close()
}

fun solve(arr: MutableList<Int>, n: Int, start: Int) {
    if (arr.size == n) {
        count += 1
        return
    }

    for (i in start until n) {
        arr.add(i)
        solve(arr.toMutableList(), n, i + 1)
        arr.removeLast()
    }
}