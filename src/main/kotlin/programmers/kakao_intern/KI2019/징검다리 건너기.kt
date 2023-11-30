package programmers.KI2019.징검다리건너기

// 못품

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var result = 0
        var (left, right) = 0 to stones.maxOf { it }

        while (left <= right) {
            val mid = (left + right) / 2
            var cnt = 0
            for (i in stones.indices) {
                val diff = stones[i] - mid
                if (diff <= 0) {
                    cnt += 1
                } else {
                    cnt = 0
                }

                if (cnt >= k) {
                    result = mid
                    right = mid - 1
                    break
                }
            }

            if (cnt < k) {
                left = mid + 1
            }
        }

        return result
    }
}