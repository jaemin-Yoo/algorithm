package boj.depth_first_search

/**
 * 문제 번호: (2668)
 * 문제 이름: (숫자고르기)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = IntArray(n + 1)
    val visited = BooleanArray(n + 1)
    for (i in 1 until n + 1) {
        val a = readLine().toInt()
        arr[i] = a
    }

    val result = mutableListOf<Int>()
    for (i in 1 until n + 1) {
        if (!visited[i]) {
            val list = solve(arr, visited, n, i).map {
                visited[it] = true
                it
            }
            result.addAll(list)
        }
    }
    result.sort()
    println(result.size)
    result.forEach {
        println(it)
    }
    close()
}

private fun solve(arr: IntArray, visited: BooleanArray, n: Int, start: Int): List<Int> {
    val innerVisited = BooleanArray(n + 1)
    val aList = mutableListOf<Int>()
    var a = start
    while (true) {
        innerVisited[a] = true
        aList.add(a)
        a = arr[a]
        if (innerVisited[a]) {
            val idx = aList.indexOf(a)
            return aList.subList(idx, aList.size)
        } else if (visited[a]) {
            return emptyList()
        }
    }
}