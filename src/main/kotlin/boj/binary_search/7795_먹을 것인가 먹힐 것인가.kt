package boj.binary_search

/**
 * 문제 번호: (7795)
 * 문제 이름: (먹을 것인가 먹힐 것인가)
 * 소요 시간(분): (7)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(' ').map { it.toInt() }
        val a = br.readLine().split(' ').map { it.toInt() }
        val b = br.readLine().split(' ').map { it.toInt() }.sorted().toIntArray()

        var result = 0
        a.forEach {
            result += binarySearch(b, it)
        }
        println(result)
    }
}

private fun binarySearch(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.lastIndex
    var result = 0
    while (start <= end) {
        val mid = (start + end) / 2
        if (arr[mid] < target) {
            start = mid + 1
            result = mid + 1
        } else {
            end = mid - 1
        }
    }
    return result
}