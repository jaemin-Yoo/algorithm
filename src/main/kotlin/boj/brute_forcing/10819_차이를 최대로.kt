package boj.brute_forcing

/**
 * 문제 번호: (10819)
 * 문제 이름: (차이를 최대로)
 * 소요 시간(분): (30)
 */

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }.sorted()
    val newList = mutableListOf<Int>()
    for (i in 0 until n / 2) {
        if (i % 2 == 0) {
            newList.add(arr[i])
            newList.add(0, arr[n - i - 1])
        } else {
            newList.add(0, arr[i])
            newList.add(arr[n - i - 1])
        }
    }
    if (n % 2 == 1) {
        if (abs(newList.first() - arr[n / 2]) > abs(newList.last() - arr[n / 2])) {
            newList.add(0, arr[n / 2])
        } else {
            newList.add(arr[n / 2])
        }
    }
    var result = 0
    for (i in 0 until n - 1) {
        result += abs(newList[i] - newList[i + 1])
    }
    println(result)
    close()
}