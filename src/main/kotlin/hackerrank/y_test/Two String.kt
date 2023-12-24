package hackerrank.y_test

/**
 * 문제: 두 문자열의 각 문자별 아스키 코드 차이를 K를 넘지 않을 만큼 차례로 더해 가장 큰 최대 길이 구하기
 */

import kotlin.math.max
import kotlin.math.abs

fun sameSubstring(s: String, t: String, K: Int): Int {
    // Write your code here
    val arr = diffCountArr(s, t)
    var start = 0
    var end = 0
    var sum = arr[0]
    var maxLength = 0
    while (end < s.length) {
        if (sum <= K) {
            maxLength = max(maxLength, end - start + 1)
        }

        if (sum <= K) {
            end += 1
            if (end >= s.length) break

            sum += arr[end]
        } else {
            sum -= arr[start]
            start += 1
        }
    }

    return maxLength
}

private fun diffCountArr(s: String, t: String): IntArray {
    val arr = IntArray(s.length)
    for (i in s.indices) {
        val diff = abs(s[i].code - t[i].code)
        arr[i] = diff
    }

    return arr
}