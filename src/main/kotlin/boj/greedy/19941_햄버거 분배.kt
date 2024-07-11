package boj.greedy

/**
 * 문제 번호: (19941)
 * 문제 이름: (햄버거 분배)
 * 소요 시간(분): (10)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val arr = br.readLine().toCharArray()
    var cnt = 0
    for (i in 0 until n) {
        if (arr[i] == 'P') {
            for (j in -k until k + 1) {
                if (i + j in 0 until n && arr[i + j] == 'H') {
                    arr[i + j] = 'X'
                    cnt++
                    break
                }
            }
        }
    }
    println(cnt)
}