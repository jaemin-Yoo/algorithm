package boj.two_pointer

/**
 * 문제 번호: (3273)
 * 문제 이름: (두 수의 합)
 * 소요 시간(분): (8)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }.sorted()
    val x = br.readLine().toInt()
    var start = 0
    var end = arr.lastIndex
    var cnt = 0
    while (start < end) {
        if (arr[start] + arr[end] > x) {
            end--
        } else {
            if (arr[start] + arr[end] == x) {
                cnt++
            }
            start++
        }
    }
    println(cnt)
}