package boj.binary_search

/**
 * 문제 번호: (12015)
 * 문제 이름: (가장 긴 증가하는 부분 수열 2)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map{ it.toInt() }
    val temp = mutableListOf<Int>()

    for (x in list) {
        val idx = binarySearch(x, temp)
        if (idx == -1) {
            temp.add(x)
        } else {
            temp[idx] = x
        }
    }
    println(temp.size)
    close()
}

private fun binarySearch(x: Int, temp: MutableList<Int>): Int {
    if (temp.isEmpty()) {
        return -1
    }

    var left = 0
    var right = temp.lastIndex
    var mid = 0
    while (left <= right) {
        mid = (left + right) / 2
        val a = temp[mid]
        if (x > a) {
            left = mid + 1
        } else if (x < a) {
            right = mid - 1
        } else {
            break
        }
    }

    return if (right < 0) {
        0
    } else if (left > temp.lastIndex) {
        -1
    } else if (x > temp[mid]) {
        mid + 1
    } else if (x < temp[mid]) {
        mid
    } else {
        mid
    }
}