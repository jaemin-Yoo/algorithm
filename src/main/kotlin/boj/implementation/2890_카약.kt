package boj.implementation

/**
 * 문제 번호: (2890)
 * 문제 이름: (카약)
 * 소요 시간(분): (20)
 */

private const val TEAM_COUNT = 9

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val teams = IntArray(TEAM_COUNT + 1) { 1 }
    val arr = mutableListOf<Pair<Int, Int>>()
    repeat(r) {
        val row = readLine()
        for (i in 1 until c - 1) {
            if (row[i] != '.') {
                arr.add(row[i].toString().toInt() to i)
                break
            }
        }
    }
    arr.sortByDescending { it.second }
    for (i in 1 until TEAM_COUNT) {
        val preNum = arr[i - 1].first
        val num = arr[i].first

        if (arr[i - 1].second != arr[i].second) {
            teams[num] = teams[preNum] + 1
        } else {
            teams[num] = teams[preNum]
        }
    }
    for (i in 1 until TEAM_COUNT + 1) {
        println(teams[i])
    }
    close()
}