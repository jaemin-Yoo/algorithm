package boj.hashing

/**
 * 문제 번호: (23057)
 * 문제 이름: (도전 숫자왕)
 * 소요 시간(분): (x)
 */

private val sumList = hashSetOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val maxSum = arr.sum()
    dfs(arr, 0, 0)
    println(maxSum - sumList.size + 1)
    close()
}

private fun dfs(arr: List<Int>, idx: Int, sum: Int) {
    sumList.add(sum)
    if (idx == arr.size) return

    dfs(arr, idx + 1, sum)
    dfs(arr, idx + 1, sum + arr[idx])
}