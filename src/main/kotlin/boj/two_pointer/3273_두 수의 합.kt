package boj.two_pointer

/**
 * 문제 번호: (3273)
 * 문제 이름: (두 수의 합)
 * 소요 시간(분): (3)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }.sorted()
    val x = br.readLine().toInt()
    var p1 = 0
    var p2 = n - 1
    var cnt = 0
    while (p1 < p2) {
        if (arr[p1] + arr[p2] < x) {
            p1++
        } else if (arr[p1] + arr[p2] > x) {
            p2--
        } else {
            cnt++
            p2--
        }
    }
    print(cnt)
}