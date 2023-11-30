package programmers.카카오인턴십2020.보석쇼핑

// 44분

import java.util.Queue
import java.util.LinkedList

class Solution {
    fun solution(gems: Array<String>): IntArray {
        val uniqueGems = gems.distinct()
        val gemTypeSize = uniqueGems.size
        val map = HashMap<String, Int>()
        for (gem in uniqueGems) {
            map[gem] = 0
        }

        var startIndex = 0
        val basket = mutableSetOf<String>()
        val q: Queue<String> = LinkedList()
        var minSize = Int.MAX_VALUE
        val result = IntArray(2)
        for (i in gems.indices) {
            val gem = gems[i]
            q.add(gem)
            basket.add(gem)
            map[gem] = map[gem]!! + 1

            if (q.size > 1 && q.peek() == gem) {
                while (map[q.peek()]!! > 1) {
                    val peekGem = q.poll()
                    map[peekGem] = map[peekGem]!! - 1
                    startIndex += 1
                }

            }

            if (basket.size == gemTypeSize) {
                if (minSize > q.size) {
                    result[0] = startIndex + 1
                    result[1] = i + 1
                    minSize = q.size
                }
            }
        }

        return result
    }
}

