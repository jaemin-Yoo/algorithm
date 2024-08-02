package boj.two_pointer

/**
 * 문제 번호: (2531)
 * 문제 이름: (회전 초밥)
 * 소요 시간(분): (23)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, d, k, c) = br.readLine().split(' ').map { it.toInt() }
    val sushi = IntArray(n)
    for (i in 0 until n) {
        val s = br.readLine().toInt()
        sushi[i] = s
    }

    val selected = HashMap<Int, Int>()
    selected[c] = 1
    var cnt = 1
    for (i in 0 until k) {
        val s = sushi[i]
        if (selected.containsKey(s)) {
            selected[s] = selected[s]!! + 1
        } else {
            selected[s] = 1
            cnt++
        }
    }

    var start = 0
    var end = k - 1
    var result = cnt
    while (start < n) {
        val ss = sushi[start++]
        selected[ss] = selected[ss]!! - 1
        if (selected[ss] == 0) {
            cnt--
        }

        end = (end + 1) % n
        val se = sushi[end]
        if (selected.containsKey(se)) {
            selected[se] = selected[se]!! + 1
        } else {
            selected[se] = 1
        }
        if (selected[se] == 1) {
            cnt++
        }

        result = max(result, cnt)
    }
    println(result)
}