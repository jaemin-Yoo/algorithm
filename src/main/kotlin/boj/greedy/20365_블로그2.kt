package boj.greedy

/**
 * 문제 번호: (20365)
 * 문제 이름: (블로그2)
 * 소요 시간(분): (8)
 */

import kotlin.math.min

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = br.readLine()
    var rCnt = 0
    var bCnt = 0
    var color: Char? = null
    for (i in 0 until n) {
        if (arr[i] == 'B' && color != 'B') {
            bCnt++
            color = 'B'
        } else if (arr[i] == 'R' && color != 'R') {
            rCnt++
            color =  'R'
        }
    }
    println(min(rCnt, bCnt) + 1)
}