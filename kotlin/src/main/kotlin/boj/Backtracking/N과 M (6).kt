package boj.Backtracking.N과M6

private val result = mutableListOf<MutableList<Int>>()

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.sorted()
    solve(0, m, list, mutableListOf())
    result.forEach {
        println(it.joinToString(" "))
    }
}

fun solve(start: Int, n: Int, list: List<Int>, arr: MutableList<Int>) {
    if (arr.size == n) {
        result.add(arr)
        return
    }

    for (i in start until list.size) {
        arr.add(list[i])
        solve(i + 1, n, list, arr.toMutableList())
        arr.removeLast()
    }
}