package boj.greedy

/**
 * 문제 번호: (20300)
 * 문제 이름: (서강근육맨)
 * 소요 시간(분): (16)
 */

import kotlin.math.max

fun main() = System.`in`.bufferedReader().use { br ->
	val n = br.readLine().toInt()
	val arr = br.readLine().split(' ').map { it.toLong() }.sorted()
	var m = 0L
	if (n % 2 == 0) {
		for (i in 0 until n / 2) {
			m = max(m, arr[i] + arr[n - i - 1])
		}
	} else {
		m = arr[n - 1]
		for (i in 0 until n / 2) {
			m = max(m, arr[i] + arr[n - i - 2])
		}
	}
	print(m)
}
