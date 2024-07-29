package boj.two_pointer

/**
 * 문제 번호: (20922)
 * 문제 이름: (겹치는 건 싫어)
 * 소요 시간(분): (20)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val a = br.readLine().split(' ').map { it.toInt() }

    var start = 0
    var end = 1
    var result = 1
    val map = HashMap<Int, Int>()
    map[a[start]] = 1
    while (end < n) {
        val ev = a[end]
        if (map.containsKey(ev)) {
            map[ev] = map[ev]!! + 1
        } else {
            map[ev] = 1
        }

        while (map[ev]!! > k) {
            map[a[start]] = map[a[start]]!! - 1
            start++
        }
        result = max(result, end - start + 1)
        end++
    }
    println(result)
}