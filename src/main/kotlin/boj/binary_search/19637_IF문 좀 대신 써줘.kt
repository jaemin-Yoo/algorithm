package boj.binary_search

/**
 * 문제 번호: (19637)
 * 문제 이름: (IF문 좀 대신 써줘)
 * 소요 시간(분): (11)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val arr = mutableListOf<Pair<String, Int>>()
    repeat(n) {
        val (s, v) = br.readLine().split(' ')
        arr.add(s to v.toInt())
    }
    val sb = StringBuilder()
    repeat(m) {
        val a = br.readLine().toInt()
        val result = binarySearch(arr, a)
        sb.appendLine(result)
    }
    print(sb)
}

private fun binarySearch(arr: List<Pair<String, Int>>, target: Int): String {
    var start = 0
    var end = arr.lastIndex
    var result = ""
    while (start <= end) {
        val mid = (start + end) / 2
        val (s, v) = arr[mid]
        if (v >= target) {
            end = mid - 1
            result = s
        } else {
            start = mid + 1
        }
    }
    return result
}